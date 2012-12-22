#!/bin/bash -e 
ROOT=..
OUT=out
THIRD_PARTY_DIR=$ROOT/../third_party

SOY_COMPILER=$THIRD_PARTY_DIR/js/soy/SoyToJsSrcCompiler.jar
DEPS_COMPILER=$THIRD_PARTY_DIR/js/closure-library/closure/bin/build/depswriter.py
CLOSURE_BUILDER=$THIRD_PARTY_DIR/js/closure-library/closure/bin/build/closurebuilder.py
CLOSURE_COMPILER=$THIRD_PARTY_DIR/js/closure-compiler/compiler.jar

HTML_DIR=hml/hangout
HTML_FILE=$HTML_DIR/dev.html
HTML_DEPS=JS_DEPS

rm -rf $OUT
mkdir $OUT

# Compile templates
find templates -name "*.soy" | xargs java -jar $SOY_COMPILER \
  --shouldProvideRequireSoyNamespaces \
  --outputPathFormat "$OUT/{INPUT_DIRECTORY}/{INPUT_FILE_NAME_NO_EXT}.js"

# Create the deps file
$DEPS_COMPILER \
  --output_file=$OUT/deps.js \
  --root_with_prefix="$OUT ../../../../../web/hml/hangout/$OUT" \
  --root_with_prefix="$ROOT/hml ../../../../../web/hml"
