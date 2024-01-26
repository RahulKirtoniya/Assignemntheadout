# Assignemntheadout
Assignment Headout

Project Description:

This repository contains a simple HTTP server implemented in Java using the Spark framework. The server responds to GET requests on the "/data" endpoint, allowing users to retrieve content from specified files. The project is designed to handle query parameters, providing flexibility for users to request either the entire content of a file or a specific line.

Features:

Endpoint: /data
Query Parameters: n (file name), m (line number)
Retrieve entire file content or a specific line based on query parameters
Dockerized for easy deployment
Compatible with both ARM and x86 architectures
Usage:

Send GET requests to /data with appropriate query parameters.
Retrieve file content based on provided parameters.
Building and Running:

Use Maven to build the project.
Dockerize the application using the provided Dockerfile.
Run the Docker container, exposing port 8080.
Explore the code to understand the implementation and customize it according to your needs. This project serves as a foundation for a lightweight HTTP server with file content retrieval capabilities.
