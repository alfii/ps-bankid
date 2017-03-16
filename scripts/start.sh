#!/bin/bash

# Adaptions
if [ -d "/adaptions" ]; then
    # make scripts executable incase they aren't
    chmod -Rf 750 /adaptions/*

    # run scripts in number order
    for i in `ls /adaptions/`; do /adaptions/$i ; done
fi

if [ ! -d /keystore ];
then
    echo "Keystore /keystore is not mounted with keys"
    exit 1
fi

if [ ! -d /data ];
then
    echo "Missing /data directory with code to execute"
    echo "Startup command is: command=java -cp lib/bcmail-jdk15-1.45.jar:lib/bcprov-jdk15-1.45.jar:ca-integration-server.jar melin.server.ServerHost"
    exit 1
fi

# Start supervisord and services
/usr/bin/supervisord -n -c /etc/supervisord.conf
