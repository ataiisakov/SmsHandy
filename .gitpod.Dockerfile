FROM gitpod/workspace-full-vnc

RUN apt-get update && apt-get install -y --no-install-recommends xvfb openjfx && rm -rf /var/lib/apt/lists/*


# Install custom tools, runtime, etc. using apt-get
# For example, the command below would install "bastet" - a command line tetris clone:
#
# RUN sudo apt-get -q update && \
#     sudo apt-get install -yq bastet && \
#     sudo rm -rf /var/lib/apt/lists/*
#
# More information: https://www.gitpod.io/docs/config-docker/
