#!/bin/bash

tomee/bin/shutdown.sh
. clean.sh
. javac.sh
. deploy.sh
tomee/bin/startup.sh
