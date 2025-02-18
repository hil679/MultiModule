# gradle build
to use jar file and upload it in operating server

- additional configuration for multimodule build with gradle
  ```
  tasks.bootJar { enabled = false }
  tasks.jar { enabled = true }
  ```
  - bootJar<br>
    bootJar default is true.
    And if it is true, it produce jar file.
    But, common module is only called as reference in other mouldes.
    So it doesn't need to create jar file. <br>
    If it is true, it's trying to find ``` main class ```. Therefore it makes error.
      - <b>That's why it is set to false</b>
  - jar<br>
    jar default is true. only need plane.jar.
  - difference jar and bootJar
    - naming
      - bootjar : xxx.jar
      - jar: xxx-plane.jar (it doesn't contain dependancy, only include classes and resources)
        - cannot execute with java -jar command
<br>
- build command
  ```aidl
    ./gradlew clean :module-api:buildNeeded --stacktrace --info --refresh-dependencies -x test
  ```
  - :module-api:buildNeeded : module-api 빌드한다.
  - stacktrace: 빌드를 진행하며 발생하는 로깅 혹은 예외를 빠르게 캐치할 수 있도록 로그를 쌓아서 보여달라
  - info: 로깅레벨(debug -> info -> warn -> error)을 info 이상으로 설정 
  - refresh-dependencies: dependecy를 한번 더 refresh
  - -x test: build시 test코드 체크는 skip (중요)
       예를들어 타인이 작성한 테스트코드 내가 건들 수 없음, 타인의 브랜치에서 수정해야 정상반영 되는 등의 이유
- Execute jar <br>
  move path
  ```
    cd module-api/build/libs
  ```
  execute jar
  ```
  java -jar module-api-0.0.1-SNAPSHOT.jar
  ```
  
# profile setting with java jar command
```
java -jar "-Dspring.profiles.active=local" module-api-0.0.1-SNAPSHOT.jar
```