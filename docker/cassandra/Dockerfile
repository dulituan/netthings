#
# Copyright © 2016-2018 dujoy.cn
#

FROM cassandra:3.11.2

ADD ready-probe.sh /ready-probe.sh

RUN chmod +x /ready-probe.sh

CMD ["cassandra", "-f"]