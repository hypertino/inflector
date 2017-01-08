#! /bin/bash
set -e

if [[ "$TRAVIS_PULL_REQUEST" == "false" && "$TRAVIS_BRANCH" == "master" ]]; then
  echo "$key_password" | gpg --passphrase-fd 0 ./travis/ht-oss-public.asc.gpg
  echo "$key_password" | gpg --passphrase-fd 0 ./travis/ht-oss-private.asc.gpg

  if grep "version\s*:=.*SNAPSHOT" build.sbt; then
    sbt ++$TRAVIS_SCALA_VERSION test publishSigned
  else
    sbt ++$TRAVIS_SCALA_VERSION test publishSigned
  	# wait different time for different jobs, due to race condition releasing in sonatype
  	if [[ "$TRAVIS_JOB_NUMBER" =~ ^[[:digit:]]+\.([[:digit:]]+)$ ]]; then
  		job_number=${BASH_REMATCH[1]}
  		wait_time=$((($job_number-1)*20))
  		echo "Waiting for job $job_number ($TRAVIS_JOB_NUMBER) for $wait_time seconds..."
  		sleep $wait_time
  	fi
    sbt ++$TRAVIS_SCALA_VERSION sonatypeReleaseAll
  fi
else
  sbt ++$TRAVIS_SCALA_VERSION test
fi
