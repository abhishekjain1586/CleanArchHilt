package com.example.cleanarchhilt.common.network.exceptions

class ApiException(message: String?) : Exception(message)

class ServerException(message: String?) : Exception(message)

class NetworkException(message: String?) : Exception(message)