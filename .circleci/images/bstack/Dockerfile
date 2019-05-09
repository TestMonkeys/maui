FROM openjdk:8u212-jdk-alpine3.9

RUN apk add --no-cache git openssh tar gzip ca-certificates maven

RUN wget https://www.browserstack.com/browserstack-local/BrowserStackLocal-linux-x64.zip
RUN unzip BrowserStackLocal-linux-x64.zip
RUN rm BrowserStackLocal-linux-x64.zip
RUN mv BrowserStackLocal /usr/bin/
RUN chmod 777 /usr/bin/BrowserStackLocal
