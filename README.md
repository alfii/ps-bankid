# ps-bankid

Example Dockerfile:

```
FROM pasientskyhosting:ps-bankid:latest
MAINTAINER Andreas Krüger <ak@patientsky.com>

# Add keystore files
COPY keystore /keystore

# Add bankid jar files to /data
COPY src /data
```
