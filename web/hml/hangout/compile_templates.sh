#!/bin/bash -e
rm -rf out
mkdir out

find templates -name "*.soy" | xargs java -jar ../../../third_party/js/soy/SoyToJsSrcCompiler.jar --outputPathFormat "out/{INPUT_DIRECTORY}/{INPUT_FILE_NAME_NO_EXT}.js"
