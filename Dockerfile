FROM ubuntu:latest
LABEL authors="ggowt"

ENTRYPOINT ["top", "-b"]