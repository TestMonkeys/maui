FROM openjdk:8u212-jdk-stretch


RUN apt-get update && apt-get install -y git tar gzip ca-certificates maven && rm -rf /var/lib/apt/lists/*

RUN wget https://www.browserstack.com/browserstack-local/BrowserStackLocal-linux-x64.zip
RUN unzip BrowserStackLocal-linux-x64.zip
RUN rm BrowserStackLocal-linux-x64.zip
RUN mv BrowserStackLocal /usr/bin/
RUN chmod 777 /usr/bin/BrowserStackLocal

CMD ["/bin/sh"]