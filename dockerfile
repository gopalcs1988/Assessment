# Use Maven 3.6.3 with JDK 11 as the base image
FROM maven:3.6.3-jdk-11

# Set the working directory inside the container
WORKDIR /usr/src/app

# Copy the project's POM file to the working directory
COPY pom.xml .

# Resolve project dependencies. This step downloads all dependencies specified in the POM file.
RUN mvn dependency:go-offline

# Copy the entire project source code to the working directory
COPY . .

# Set permissions to make all files executable within the working directory
RUN chmod -R 777 /usr/src/app

# Clean the Maven project
RUN mvn clean

# Run the tests
CMD ["mvn", "test"]
