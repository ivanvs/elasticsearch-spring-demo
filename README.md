# elasticsearch-spring-demo
Application demonstrate how to create small Spring application that is listening on Twitter public stream. Application persist tweets in MySQL and ElasticSearch databases and enables user to search tweets from MySQL and ElasticSearch.

## About

This application was created as demo included in [presentation](http://www.slideshare.net/IvanVasiljevi/elasticsearch-62070143). 

## What You Need To Install?

* Java 1.8
* [Maven](https://maven.apache.org/download.cgi)
* [NodeJS](https://nodejs.org/en/)
* [Bower](http://bower.io/)
* MySQL
* [ElasticSearch 1.7.3](https://www.elastic.co/downloads/past-releases/elasticsearch-1-7-3)

## How To Setup Twitter

In order to be able to read tweets from Twitter API you need to create application on [Twitter](https://dev.twitter.com/). Tutorial how can you create Twitter application you can find on this [link](http://iag.me/socialmedia/how-to-create-a-twitter-app-in-8-easy-steps/).

When you have created Twitter application in [resource file](https://github.com/ivanvs/elasticsearch-spring-demo/blob/master/src/main/resources/application.properties) you need to replace next fields with keys from your application:

* spring.social.twitter.appId
* spring.social.twitter.appSecret
* spring.social.twitter.accessToken
* spring.social.twitter.accessTokenSecret

## MySQL Setup

Paramaters for connecting to MySQL database can be found in [resource file](https://github.com/ivanvs/elasticsearch-spring-demo/blob/master/src/main/resources/application.properties):

* spring.datasource.url
* spring.datasource.username
* spring.datasource.password

As you can see from default configuration, in MySQL you have to create database scheme es_demo.

# ElasticSearch Setup

You should setup your ElasticSearch instance to have cluster name: **web_app_demo**

## How To Build Application

In order to build application you need to download javascript resources. This can be done with bower by running command in root folder:

`bower install`

## How To Start Application

In order to start application you need to run maven command in root folder of application:

`mvn spring-boot:run`

## Databases

If you for some reason don't want to install MySQL and ElasticSearch on your machine, you can use supplied docker-compose configuration file.

### What You Need To Install?

* [Docker](https://docs.docker.com/)
* [Doker Compose](https://docs.docker.com/compose/install/)

### How To Start Containers?

In order to start **MySQL** container and **ElasticSearch** container this need to be done:

* Open terminal in `docker` folder of this project
* Start docker-compose with command: `docker-compose up` or `sudo docker-compose up`

Pay attention that this two containers expect **ports 3306, 9200 and 9300 to be free**.

## License

elasticsearch-spring-demo is released under [MIT License](https://opensource.org/licenses/MIT).
