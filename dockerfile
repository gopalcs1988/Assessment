FROM maven:3.6.3-jdk-11

ENV CHROMEDRIVER_VERSION=126.0.6478.126

# install chrome
RUN apt-get update && apt-get install -y wget && apt-get install -y zip
RUN wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt-get install -y ./google-chrome-stable_current_amd64.deb

# install chromedriver
RUN wget https://storage.googleapis.com/chrome-for-testing-public/$CHROMEDRIVER_VERSION/linux64/chromedriver-linux64.zip \
  && unzip chromedriver-linux64.zip && rm -dfr chromedriver_linux64.zip \
  && mv /chromedriver-linux64/chromedriver /usr/bin/chromedriver \
  && chmod +x /usr/bin/chromedriver

ENV PATH /usr/bin/chromedriver:$PATH

RUN chmod 755 /usr/bin/chromedriver

# Copy the project into the container
WORKDIR /usr/src/app
COPY . .

# Build the project
RUN mvn clean

# Run the tests
CMD ["mvn", "test"]