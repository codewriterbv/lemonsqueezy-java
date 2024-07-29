# Publish to Maven

## Create GnuPG key

Follow steps on https://maciejwalkowiak.com/blog/publish-java-library-maven-central/#_3-create-gpg-keys

```shell
brew install gnupg
gpg --gen-key
gpg --keyserver keyserver.ubuntu.com --send-keys KEYID
gpg --export KEYID | base64
gpg --export-secret-keys KEYID | base64
```

