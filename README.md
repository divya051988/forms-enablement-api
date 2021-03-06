[![Circle CI](https://circleci.com/gh/companieshouse/forms-enablement-api/tree/develop.svg?style=shield&circle-token=9ff96b9c65cc014e6bf6dff7e66fe8ad9aa8315e)](https://circleci.com/gh/companieshouse/forms-enablement-api/tree/develop)

Companies House Forms Enablement API Service
=====================

The tool accepts forms posted from Salesforce, converts them to an agreed format and posts them to Companies House Information Processing System (CHIPS).
This API is for internal use only and is not provided for development by third parties.

### About this application

This application is written using the [Dropwizard](http://www.dropwizard.io/) Java framework.

### Prerequisites

In order to run the tool locally you'll need the following installed on your machine:

- [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)

### Getting Started

Run the following from the command line to download the repository and change into the directory:

```
git clone git@github.com:companieshouse/forms-enablement-api.git

cd forms-enablement-api
```


### Running the development server

To run the server type the following command in your terminal

```bash
./run.sh
```

or on windows

```
mvn clean package
java -jar target/formsapiservice-1.0-SNAPSHOT.jar server configuration.yml

```
Then you can now visit [http://localhost:8080/](http://localhost:8080/) in your browser


### Code style

We are using the [Google Java Style](https://google.github.io/styleguide/javaguide.html) enforced by the Maven
[checkstyle](https://maven.apache.org/plugins/maven-checkstyle-plugin/) plugin
