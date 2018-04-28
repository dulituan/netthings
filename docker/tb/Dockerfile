#
# Copyright © 2016-2018 dujoy.cn
#

FROM openjdk:8-jre

ADD run-application.sh /run-application.sh
ADD thingsboard.deb /thingsboard.deb

RUN apt-get update \
        && apt-get install -y nmap \
        && chmod +x /run-application.sh
