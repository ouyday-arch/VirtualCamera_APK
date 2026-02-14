# Ghost Configuration Engine

This directory contains the core configuration and management tools for creating a ghost identity profile that can be used to create a realistic device fingerprint.

## Files:

- `ghost_identity_master.json` - The master golden profile containing all device specifications, unique identifiers, and system properties.
- `sentry_audit.py` - Device compliance audit tool that validates current device state against the golden profile.
- `remediation_logic.py` - Remediation procedures to apply changes needed to match the golden profile.
- `tee_mask.py` - TEE attestation masking tools for TrickyStore integration.

## Usage:

1. Run `python sentry_audit.py` to verify device compliance
2. Run `python remediation_logic.py` to apply necessary changes
3. Use `ghost_identity_master.json` as your reference for all device configurations

This engine is designed to work with ADB commands and requires a rooted Android device running Android 13 or higher.
