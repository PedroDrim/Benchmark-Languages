#!/bin/bash

export GOPATH=$HOME/MEGA/MEGAsync/Repositorio_Git/Benchmark-branches/simpleClass/Benchmark-Languages/Languages/golang

go build start.go
./start $1
