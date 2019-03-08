#!/bin/bash

export GOPATH=$(pwd)

go build start.go
./start $1
