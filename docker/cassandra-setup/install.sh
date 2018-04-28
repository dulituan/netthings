#!/bin/bash
#
# Copyright © 2016-2018 dujoy.cn
#


dpkg -i /thingsboard.deb

until nmap $CASSANDRA_HOST -p $CASSANDRA_PORT | grep "$CASSANDRA_PORT/tcp open"
do
  echo "Wait for cassandra db to start..."
  sleep 10
done

echo "Creating 'Thingsboard' schema and system data..."
if [ "$ADD_DEMO_DATA" == "true" ]; then
    echo "plus demo data..."
    /usr/share/thingsboard/bin/install/install.sh --loadDemo
elif [ "$ADD_DEMO_DATA" == "false" ]; then
    /usr/share/thingsboard/bin/install/install.sh
fi
