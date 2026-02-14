import json
import subprocess
import os

def load_ghost_profile():
    """Load the ghost identity master profile"""
    try:
        with open('Ghost_Config_Engine/ghost_identity_master.json', 'r') as f:
            return json.load(f)
    except FileNotFoundError:
        print("[!] Ghost identity master file not found!")
        return None
    except Exception as e:
        print(f"[!] Error loading ghost profile: {e}")
        return None

def check_root_components():
    """Check for root components that shouldn't be visible"""
    violations_found = []
    
    # Check for su binary
    try:
        result = subprocess.run(['adb', 'shell', 'ls -l /sbin/su'], 
                              capture_output=True, text=True)
        if "/sbin/su" in result.stdout:
            print("[!] Found root binary: /sbin/su")
            violations_found.append("Root binary")
    except Exception as e:
        pass
    
    # Check for Magisk directory
    try:
        result = subprocess.run(['adb', 'shell', 'ls -l /data/adb/magisk'], 
                              capture_output=True, text=True)
        if "/data/adb/magisk" in result.stdout:
            print("[!] Found Magisk directory: /data/adb/magisk")
            violations_found.append("Magisk directory")
    except Exception as e:
        pass
    
    # Check for Zygisk strings in memory
    try:
        result = subprocess.run(['adb', 'shell', 'cat /proc/self/maps'], 
                              capture_output=True, text=True)
        if "zygisk" in result.stdout.lower():
            print("[!] Found Zygisk in memory maps")
            violations_found.append("Zygisk in memory maps")
    except Exception as e:
        pass
    
    return violations_found

def check_stealth_properties():
    """Check stealth properties"""
    print("\n[*] Checking Stealth Properties:")
    
    # Check for specific stealth properties
    stealth_props = [
        ("ro.boot.flash.locked", "1"),
        ("ro.boot.verifiedbootstate", "green"), 
        ("ro.boot.vbmeta.device_state", "locked")
    ]
    
    all_passed = True
    
    for prop_name, expected_value in stealth_props:
        try:
            result = subprocess.run(['adb', 'shell', f'getprop {prop_name}'], 
                                  capture_output=True, text=True)
            actual_value = result.stdout.strip()
            
            if actual_value == expected_value:
                print(f"   ✓ {prop_name}: {actual_value}")
            else:
                print(f"   ✗ {prop_name}: Expected '{expected_value}', got '{actual_value}'")
                all_passed = False
        except Exception as e:
            print(f"   ✗ {prop_name}: Error checking property")
            all_passed = False
    
    return all_passed

def check_hidden_components():
    """Check for hidden components"""
    print("\n[*] Checking for hidden components:")
    
    # Check if Magisk binaries are properly hidden
    try:
        result = subprocess.run(['adb', 'shell', 'ls -l /system/bin/magisk'], 
                              capture_output=True, text=True)
        if "No such file or directory" in result.stderr:
            print("   ✓ Magisk binary properly hidden")
        else:
            print("   ✗ Magisk binary not properly hidden")
    except Exception as e:
        pass
    
    # Check for mount namespace isolation
    try:
        result = subprocess.run(['adb', 'shell', 'cat /proc/self/mounts'], 
                              capture_output=True, text=True)
        if "tmpfs" in result.stdout and "/data/adb/camera_ns" in result.stdout:
            print("   ✓ Mount namespace isolation active")
        else:
            print("   [i] Mount namespace isolation may not be fully active")
    except Exception as e:
        pass

def run_forensic_mock_scan():
    """Run a forensic mock-scan to check for stealth violations"""
    print("[*] Running Forensic Mock-Scan...")
    
    # Check for root components that shouldn't be visible
    violations = check_root_components()
    
    # Check stealth properties
    props_ok = check_stealth_properties()
    
    # Check hidden components
    check_hidden_components()
    
    # Provide SELinux policies to hide violations if any were found
    if violations:
        print("\n[*] SELinux Policies to Hide Violations:")
        print("1. Create a custom policy file in /sepolicy")
        print("2. Add rules like:")
        print("   allow system_app magisk_file { read open }")
        print("   allow zygote zygisk_exec { execve }")
        print("3. Load the policy with: load_policy /sepolicy")
        
        # Generate a sample SELinux policy
        selinux_policy = """
# Custom policy to hide root components
# This should be loaded into system sepolicy
        
# Hide Magisk files from normal apps
allow app_data_file magisk_file { read open };
allow app_data_file zygisk_exec { execve };

# Hide su binary access
allow system_app su_binary { execute };

# Hide mount namespace isolation
allow system_app tmpfs { mount };
"""
        print("\nGenerated SELinux Policy:")
        print(selinux_policy)
        
        return False  # Return false if violations found
    else:
        print("[+] No stealth violations detected")
        return True

def audit_device_compliance():
    """Audit device compliance with the golden profile"""
    profile = load_ghost_profile()
    
    if not profile:
        return False
    
    # Check Android version
    try:
        result = subprocess.run(['adb', 'shell', 'getprop ro.build.version.release'], 
                              capture_output=True, text=True)
        android_version = result.stdout.strip()
        
        if android_version != profile['device_profile']['android_version']:
            print(f"[!] Android version mismatch: Expected {profile['device_profile']['android_version']}, got {android_version}")
            return False
    except Exception as e:
        print(f"[!] Error checking Android version: {e}")
        return False
    
    # Check model
    try:
        result = subprocess.run(['adb', 'shell', 'getprop ro.product.model'], 
                              capture_output=True, text=True)
        model = result.stdout.strip()
        
        if model != profile['device_profile']['model']:
            print(f"[!] Model mismatch: Expected {profile['device_profile']['model']}, got {model}")
            return False
    except Exception as e:
        print(f"[!] Error checking device model: {e}")
        return False
    
    # Check security patch level
    try:
        result = subprocess.run(['adb', 'shell', 'getprop ro.build.version.security_patch'], 
                              capture_output=True, text=True)
        patch_level = result.stdout.strip()
        
        if patch_level != profile['device_profile']['security_patch_level']:
            print(f"[!] Security patch level mismatch: Expected {profile['device_profile']['security_patch_level']}, got {patch_level}")
            return False
    except Exception as e:
        print(f"[!] Error checking security patch level: {e}")
        return False
    
    # All checks passed
    print("[+] Device compliance audit PASSED")
    return True

def validate_sensor_metadata():
    """Validate sensor metadata against golden profile"""
    profile = load_ghost_profile()
    
    if not profile:
        return False
    
    try:
        sensors = profile['hardware_profile']['sensor_array']
        
        if len(sensors) < 1:
            print("[!] No sensor array found in profile")
            return False
            
        for i, sensor in enumerate(sensors):
            required_fields = ['type', 'vendor', 'resolution']
            for field in required_fields:
                if field not in sensor:
                    print(f"[!] Missing required field '{field}' in sensor {i}")
                    return False
        
        print("[+] Sensor metadata validation PASSED")
        return True
    except Exception as e:
        print(f"[!] Error validating sensor metadata: {e}")
        return False

def run_comprehensive_audit():
    """Run all audit checks"""
    print("[*] Running comprehensive device audit...")
    
    # Check device compliance
    if not audit_device_compliance():
        print("[!] Device compliance check FAILED")
        return False
    
    # Check sensor metadata
    if not validate_sensor_metadata():
        print("[!] Sensor metadata validation FAILED")
        return False
    
    # Run forensic mock scan
    if not run_forensic_mock_scan():
        print("[!] Forensic mock scan detected violations")
        return False
    
    print("[+] All audits PASSED - Device is compliant with golden profile")
    return True

if __name__ == "__main__":
    run_comprehensive_audit()
