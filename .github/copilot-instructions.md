# Copilot Instructions for Algorithm Repository

## Repository Overview

This is a **Korean language algorithm practice repository** containing solutions to coding problems from Baekjoon Online Judge (백준) and Programmers platforms. The repository uses **Kotlin** as the primary language with **Gradle** as the build system.

**Key Stats:**
- ~263 Kotlin source files (~7,948 lines of code)
- Project Type: Algorithm/Competitive Programming Solutions
- Language: Kotlin 1.9.23
- Build System: Gradle 8.5
- Runtime: JVM 11 (configured), actual Java 17 available

## Critical Build Information

### Prerequisites
**IMPORTANT:** The gradlew file may not have execute permissions after cloning. Always make it executable first:
```bash
chmod +x gradlew
```

### Build Commands (Execute in Order)

1. **Clean Build** (recommended first step):
```bash
./gradlew clean
```
Duration: ~1 second

2. **Compile Only**:
```bash
./gradlew compileKotlin
```
Duration: 25-30 seconds on first run (downloads dependencies), ~1-2 seconds cached

3. **Full Build**:
```bash
./gradlew build
```
Duration: ~30 seconds first run, ~10-12 seconds subsequent runs
- Compiles Kotlin sources
- Compiles Java sources (if any)
- Creates JAR artifact
- Runs tests (currently none exist)
- Many compiler warnings about unused parameters (expected, can be ignored)

4. **Run Tests**:
```bash
./gradlew test
```
Duration: <1 second
Note: No test infrastructure currently exists (NO-SOURCE result is normal)

5. **View Available Tasks**:
```bash
./gradlew tasks --all
```

### Build Output
- Build artifacts: `build/` directory (excluded in .gitignore)
- JAR output: `build/libs/Algorithm-1.0-SNAPSHOT.jar`
- Compilation warnings are normal - unused parameters in main() functions

## Project Structure

### Root Directory Files
```
.coderabbit.yaml       # CodeRabbit AI review configuration (Korean)
.gitignore             # Standard Gradle/IDE ignores
build.gradle.kts       # Main build configuration
settings.gradle.kts    # Project settings, Kotlin plugin version
gradlew / gradlew.bat  # Gradle wrapper scripts
gradle/                # Gradle wrapper JAR
src/                   # Source code in standard Maven layout
백준/                   # Alternative problem storage (Korean)
```

### Source Code Organization

**Primary source location:** `src/main/java/` (contains both Java and Kotlin files)

Structure under `src/main/java/`:
```
baekjoon/
├── barkingdog/         # Algorithm study problems organized by topic
│   ├── array/          # Array problems
│   ├── backtracking/   # Backtracking problems
│   ├── bfs/            # Breadth-First Search problems
│   ├── deque/          # Deque problems
│   ├── linkedList/     # Linked List problems
│   ├── queue/          # Queue problems
│   ├── recursion/      # Recursion problems
│   └── stack/          # Stack problems
├── class1/             # Baekjoon Class 1 problems
├── class2/             # Baekjoon Class 2 problems
├── problems8708/       # Specific problem set
└── [individual files]  # Standalone problem solutions (Korean names)

leetcode/               # LeetCode problem solutions
performanceTest/        # Performance testing utilities
programmers/            # Programmers platform solutions (Korean names)
templates/              # Code templates (Practice.kt)
```

**Secondary storage:** `백준/` (Korean directory name)
```
백준/
├── Bronze/    # ~36 Bronze-tier problems (each in subdirectory)
├── Silver/    # ~34 Silver-tier problems
├── Gold/      # ~21 Gold-tier problems  
└── Platinum/  # ~5 Platinum-tier problems
```

Each problem directory typically contains:
- `*.kt` - Kotlin solution file (often with Korean filename)
- `README.md` - Problem description/notes

### Configuration Files

**build.gradle.kts** - Build configuration:
- Java plugin enabled
- Kotlin JVM plugin (version 1.9.23)
- JUnit 5 for testing (configured but no tests exist)
- JVM toolchain version 11
- Maven Central repository

**settings.gradle.kts** - Project settings:
- Kotlin plugin version: 1.9.23
- Foojay resolver for toolchains

**.coderabbit.yaml** - Code review tool configuration (extensive):
- Language: Korean (ko-KR)
- Reviews follow JetBrains Kotlin style guide
- Comments in Korean
- Focus on algorithm performance improvements
- Android development best practices

## Development Workflow

### Making Code Changes

1. **Always start with a clean build** to establish baseline:
```bash
./gradlew clean build
```

2. **Create new solutions** in appropriate package:
   - Baekjoon problems: `src/main/java/baekjoon/` (organized by tier or topic)
   - Or in tier-specific directory: `백준/[Bronze|Silver|Gold|Platinum]/[Problem Number. Name]/`
   - LeetCode problems: `src/main/java/leetcode/`
   - Programmers problems: `src/main/java/programmers/`

3. **Typical file structure** for algorithm solutions:
```kotlin
package baekjoon.classN  // or appropriate package

import java.io.*

fun main() {
    // Solution code using standard input/output
    val input = readln()
    println(result)
}
```

4. **Build after changes**:
```bash
./gradlew build
```

5. **Warnings are expected** - many solutions have unused `args` parameter in main(), this is normal for competitive programming

### Testing Individual Solutions

Most solutions are standalone programs reading from stdin. To test:
```bash
./gradlew compileKotlin
kotlin -cp build/classes/kotlin/main baekjoon.packagename.FilenameKt < input.txt
```

## Known Issues & Workarounds

### Issue: Permission Denied on gradlew
**Symptom:** `bash: ./gradlew: Permission denied`
**Solution:** Run `chmod +x gradlew` before any gradle commands

### Issue: First Build Takes Long Time
**Symptom:** Initial build takes 30+ seconds
**Cause:** Gradle downloads dependencies on first run
**Solution:** This is normal; subsequent builds take ~10 seconds

### Issue: Many Compiler Warnings
**Symptom:** Warnings about unused parameters, variables, redundant initializers
**Status:** Expected behavior - competitive programming code often has unused main() args
**Action:** Can be safely ignored unless adding new patterns

### Issue: Korean Filenames in Path
**Note:** Repository uses Korean characters in directory/file names (백준/, 탑.kt, etc.)
**Consideration:** Ensure UTF-8 encoding when reading files. Locale is set to C.UTF-8 in environment.

### Issue: No Test Infrastructure  
**Status:** Repository has no unit tests (test directories are empty)
**Impact:** `./gradlew test` completes immediately with NO-SOURCE
**Action:** Do not attempt to add test infrastructure unless explicitly requested

## Dependency Information

**Runtime Dependencies:**
- kotlin-stdlib-jdk8 (version 1.9.23, transitive)

**Test Dependencies:**  
- JUnit 5 (junit-bom 5.10.0)
- JUnit Jupiter (configured but not used)

**Tool Versions:**
- Gradle: 8.5
- Kotlin: 1.9.23 (plugin), 2.2.21 (CLI runtime)
- Java: 17.0.17 (Temurin OpenJDK, though toolchain requests 11)

## Validation Steps

After any code changes:

1. **Verify compilation:**
```bash
./gradlew compileKotlin
```

2. **Verify full build:**
```bash
./gradlew build
```

3. **Check for NEW errors** (ignore existing warnings about unused parameters)

4. **Test the solution** manually if it's a problem solution:
   - Prepare test input
   - Run the compiled Kotlin class
   - Verify output matches expected result

## Code Style Guidelines

Follow **JetBrains Kotlin Style Guide** as per .coderabbit.yaml:
- Use Kotlin idioms and standard library functions
- Prefer `readln()` for console input
- Use BufferedReader/Writer for performance-critical I/O
- Package names in lowercase (e.g., `package baekjoon.class2`)
- File names may use Korean characters

## CI/CD Pipeline

**Status:** No GitHub Actions workflows or CI pipeline currently configured

**Pre-commit Checks:** None configured

**Code Review:** Automated via CodeRabbit with Korean language comments

## Important Notes

1. **Trust these instructions** - they were validated by running all commands and testing the build process
2. **Don't add test infrastructure** unless explicitly requested - this is an algorithm practice repository
3. **Korean language** is used throughout (comments, file names, directories) - this is intentional
4. **Competitive programming patterns** differ from production code - unused parameters and lack of tests are normal
5. **Incremental compilation** is fast after the initial build downloads dependencies
6. **File encoding:** Always use UTF-8 when creating/editing files due to Korean characters

## Quick Reference

Most common command sequence for working on this repository:
```bash
# First time or after pulling changes
chmod +x gradlew
./gradlew clean build

# After making changes
./gradlew build

# If build is clean, your changes are valid
```

**Build success indicates:** Code compiles, no syntax errors, ready for submission to online judge platforms.
