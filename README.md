# JOML Extensions

JOML-Ext is a set of extensions based on [JOML][joml].

`joml-geom` is the initial module, consisting of geometric primitives moved from the core JOML project.


## License and original attribution

Initial code was contributed by Kai '[httpdigest](https://github.com/httpdigest)' Burjack and originally licensed under the MIT

Adopted by The Terasology Foundation January 2021 and re-licensed under Apache 2.0 with permission

Other contributions before the adoption by Dmitrii Ivaniusin and Sebastian Fellner, later contributions by the Terasology community


## 🚀 Release Management

A _release_ denotes that an artifact for the associated commit is available for consumption. Our
[Jenkins CI/CD pipeline][jenkins] automatically builds and publishes releases for the `main` branch.
The artifact is published to our [Artifactory] under the version specified in [`build.gradle`](./build.gradle).

> ⚠ **Note:** Whether an artifact should be published as release or snapshot is determined by whether or not there is a
> `-SNAPSHOT` in the version. Publishing will fail in case publishing the same non-snapshot version is attempted
> again.

The exact build steps for this library are defined in the [Jenkinsfile](./Jenkinsfile).

🗄 [**Snapshots**][artifactory-joml-ext-snapshot] ▪ [**Releases**][artifactory-joml-ext-release]


> 🚧 TODO: how to consume joml-ext from the Terasology Artifactory (e.g., gradle dependency snippet)

### Release Process

As releases are automatically triggered from `main` the required steps to make a 
non-snapshot release for any version is as follows:

1. **Decide on release version** ▪ Which branch to publish, under which version?

    _The version number MUST be a higher SemVer than the current version of the branch to release.
     The version bump SHOULD follow SemVer specifications, e.g., increase the major version for breaking changes, or do
     a patch release for bug fixes._
 
1. **Make the release commit** ▪ Trigger a release via [Jenkins]

    _Update the version in [build.gradle](./build.gradle) and remove the `-SNAPSHOT` suffix. Commit the change with the
     following message:_

    > `release: version {{version}}`

    _Until we have automatic tagging or a tag-based release process it is recommended to manually
     [create and push an annotated tag][git-tag] for the respective version on `master`. For a library release v1.2.3
     the tag process is:_
    
    ```sh
    git tag -a v1.2.3 -m "Release version 1.2.3"
    git push --tags
    ```
    
1. **Prepare for next release** ▪ Bump to next snapshot version

    _Finally, we have to increase the version number to be able to get pre-release `-SNAPSHOT` builds for subsequent 
     commits. Therefore, the version number MUST be a higher SemVer than the version just released. This will typically
     be a minor version bump. To do this, just update the version in [build.gradle](./build.gradle) and commit the 
     change with the following message:_
    
    > `chore: prepare next snapshot for {{version}}`

<!-- References -->
[joml]: https://github.com/JOML-CI/JOML
[jenkins]: http://jenkins.terasology.io/teraorg/job/Libraries/job/joml-ext/
[git-tag]: https://www.atlassian.com/git/tutorials/inspecting-a-repository/git-tag
[artifactory]: http://artifactory.terasology.org/
[artifactory-joml-ext-snapshot]: http://artifactory.terasology.org/artifactory/webapp/#/artifacts/browse/simple/General/libs-snapshot-local/org/terasology/joml-ext
[artifactory-joml-ext-release]: http://artifactory.terasology.org/artifactory/webapp/#/artifacts/browse/simple/General/libs-release-local/org/terasology/joml-ext
