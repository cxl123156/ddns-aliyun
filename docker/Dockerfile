FROM openjdk:20-oraclelinux8
RUN mkdir -p /opt/cxl/ddns
COPY ddns-aliyun-1.0-SNAPSHOT-jar-with-dependencies.jar /opt/cxl/ddns/ddns-aliyun.jar
CMD ["java","-jar","/opt/cxl/ddns/ddns-aliyun.jar",">", "ddns.log"]
