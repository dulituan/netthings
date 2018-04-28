#!/usr/bin/env bash
#
# Copyright © 2016-2018 dujoy.cn
#

if [[ $(nodetool status | grep $POD_IP) == *"UN"* ]]; then
  if [[ $DEBUG ]]; then
    echo "UN";
  fi
  exit 0;
else
  if [[ $DEBUG ]]; then
    echo "Not Up";
  fi
  exit 1;
fi