mvn -B -Dtag=0.0.1 release:prepare \
               -DreleaseVersion=0.0.1 \
               -DdevelopmentVersion=0.0.1-Snapshot

mvn -B -s settings.xml release:perform