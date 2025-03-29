#!/bin/bash

set -x #echo on

source ./configs.sh

# Creo le cartelle necessarie alla compilazione
[ -d "${jars_path}" ] || mkdir "${jars_path}"
[ -d "${build_path}" ] || mkdir "${build_path}"
# Alternativamente è possibile creare un archivio jar senza specificare la classe che contiene il main.
jar cvf "${appjar_path}" -C "${source_path}" .
# Compilazione
javac --module-path "${javafx_sdk_path}" --add-modules=javafx.controls -d "${build_path}" --class-path "${appjar_path}" "${source_path}/myapp/Starter.java"
# Esecuzione
java --module-path "${javafx_sdk_path}" --add-modules=javafx.controls --class-path "${build_path}:${appjar_path}" "${source_path}/myapp/Starter.java"

set +x #echo off