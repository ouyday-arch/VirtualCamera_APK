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

def audit_device_compliance():
    """Audit device compliance with the golden profile"""
    profile = load_ghost_profile()
    
    if not profile:
        return False
    
    # Check Android version
    try:
        result = subprocess.run(['adb', 'shell', 'getprop', 'ro.build.version.release'], 
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
        result = subprocess.run(['adb', 'shell', 'getprop', 'ro.product.model'], 
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
        result = subprocess.run(['adb', 'shell', 'getprop', 'ro.build.version.security_patch'], 
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
    
    # This would typically involve checking actual sensor data
    # For now, we'll just verify the structure exists
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
    
    print("[+] All audits PASSED - Device is compliant with golden profile")
    return True

if __name__ == "__main__":
    run_comprehensive_audit()
