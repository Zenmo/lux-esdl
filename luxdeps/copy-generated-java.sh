#!/bin/bash
rsync -archive\
    --verbose \
    --include='*/' \
    --include='*.java' \
    --exclude='*' \
    ~/.AnyLogicPLE/Workspace8.8/Zero_engine_BUILD/src.generated/ \
    ~/.AnyLogicPLE/Workspace8.8/Zero_Interface-Loader_BUILD/src.generated/ \
    ~/.AnyLogicPLE/Workspace8.8/results_UI_BUILD/src.generated/ \
    src/main/java
