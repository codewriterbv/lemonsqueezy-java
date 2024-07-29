# Publish to Maven

## Create GPG key

Follow steps on https://maciejwalkowiak.com/blog/publish-java-library-maven-central/#_3-create-gpg-keys

```shell
brew install gnupg
gpg --gen-key
gpg --keyserver keyserver.ubuntu.com --send-keys KEYID
gpg --export KEYID | base64
gpg --export-secret-keys KEYID | base64
```

## Validate JReleaser config

```shell
$ mvn jreleaser:config
[INFO] Scanning for projects...
Downloading from central: https://repo.maven.apache.org/maven2/org/jreleaser/jreleaser-maven-plugin/1.13.1/jreleaser-maven-plugin-1.13.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/jreleaser/jreleaser-maven-plugin/1.13.1/jreleaser-maven-plugin-1.13.1.pom (3.2 kB at 8.4 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/jreleaser/jreleaser-maven-plugin/1.13.1/jreleaser-maven-plugin-1.13.1.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/jreleaser/jreleaser-maven-plugin/1.13.1/jreleaser-maven-plugin-1.13.1.jar (76 kB at 614 kB/s)
[INFO] 
[INFO] ------------------< be.codewriter:lemonsqueezy-java >-------------------
[INFO] Building lemonsqueezy-java 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------

# The following errors are expected, as the keys are configured as GitLab Action Secrets
[ERROR] == JReleaser ==
[ERROR] signing.passphrase must not be blank. Configure a value using the Maven DSL, or define a System property jreleaser.gpg.passphrase, or define a JRELEASER_GPG_PASSPHRASE environment variable, or define a key/value pair in /Users/frank/.jreleaser/config.properties with a key named JRELEASER_GPG_PASSPHRASE
[ERROR] signing.publicKey must not be blank. Configure a value using the Maven DSL, or define a System property jreleaser.gpg.public.key, or define a JRELEASER_GPG_PUBLIC_KEY environment variable, or define a key/value pair in /Users/frank/.jreleaser/config.properties with a key named JRELEASER_GPG_PUBLIC_KEY
[ERROR] signing.secretKey must not be blank. Configure a value using the Maven DSL, or define a System property jreleaser.gpg.secret.key, or define a JRELEASER_GPG_SECRET_KEY environment variable, or define a key/value pair in /Users/frank/.jreleaser/config.properties with a key named JRELEASER_GPG_SECRET_KEY
[ERROR] release.github.token must not be blank. Configure a value using the Maven DSL, or define a System property jreleaser.github.token, or define a JRELEASER_GITHUB_TOKEN environment variable, or define a key/value pair in /Users/frank/.jreleaser/config.properties with a key named JRELEASER_GITHUB_TOKEN
```
