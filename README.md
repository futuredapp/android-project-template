# ~~Project name~~ (Android)

![Bitrise](https://img.shields.io/bitrise/appid.svg?token=apptoken)

~~Short project description.~~

## Project info

- Deadline: ~~**--. --. ----**~~
- ApplicationId: ~~`com.thefuntasty.project`~~
- Supports: ~~**Dark mode, landscape orientation**~~
- Design: ~~Figma/Zeplin (add link)~~
- ~~Backend: Apiary (add link)~~
- Architecture: [MVVM](https://github.com/thefuntasty/mvvm-android)
- Interactors: Kotlin Coroutines
- Product Flavors: mock, dev, prod
- Build Variants: debug, enterprise, release
- ~~Localizations: Czech, English – POEditor (add link)~~

### Team:

- ~~Jana Nováková, PM, <jana.novakova@thefuntasty.com>~~
- ~~Jan Novák, iOS developer, <jan.novak@thefuntasty.com>~~
- ~~John Newman, tester, <john.newman@thefuntasty.com>~~

## Configuration management

### Tools

- Code style - **[ktlint](https://ktlint.github.io/)**, **[detekt](https://arturbosch.github.io/detekt/)**, **[Android lint](http://tools.android.com/tips/lint)**, **[Danger](https://github.com/thefuntasty/danger)**

## Additional Scripts

1. `clean` - remove all `build` folders
2. `lintCheck` - run `ktlint`, `detekt` and `android lint` checks. Same runs on CI.
3. `dependencyUpdates` - check if never version of used dependencies are available
