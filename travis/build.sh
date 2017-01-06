#! /bin/bash
set -e

if [[ "$TRAVIS_PULL_REQUEST" == "false" && "$TRAVIS_BRANCH" == "master" ]]; then
  echo "$key_password" | gpg --passphrase-fd 0 ./travis/ht-oss-public.asc.gpg
  echo "$key_password" | gpg --passphrase-fd 0 ./travis/ht-oss-private.asc.gpg

  if grep "version\s*:=.*SNAPSHOT" build.sbt; then
    sbt ++$TRAVIS_SCALA_VERSION test publishSigned
  else
    sbt ++$TRAVIS_SCALA_VERSION test publishSigned sonatypeReleaseAll
  fi
else
  sbt +test
fi
