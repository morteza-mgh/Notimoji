object BuildVersions {
    const val compileSdk = 35
    const val minSdk = 24
    const val targetSdk = 35

    private const val majorVersion = 1
    private const val minorVersion = 0
    private const val patchVersion = 0

    const val versionCode = (majorVersion * 10000 + minorVersion * 100 + patchVersion) * 100
    const val versionName = "$majorVersion.$minorVersion.$patchVersion"
}
