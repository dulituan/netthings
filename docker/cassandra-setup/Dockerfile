#
# Copyright © 2016-2018 dujoy.cn
#

FROM openjdk:8-jre

ADD install.sh /install.sh
ADD thingsboard.deb /thingsboard.deb

RUN apt-get update \
        && apt-get install -y nmap \
        && chmod +x /install.sh
