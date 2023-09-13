# algorithm
백준 및 알고리즘 내용 정리 프로젝트

## 목차

- [필수 사항](#필수-사항)
- [로컬에서 수행(Eclipse)](#로컬에서-수행(Eclipse))
- [로컬에서 수행 (Intellij)](#로컬에서-수행(Intellij))

## 필수 사항

시작하기 전에 다음 요구 사항을 충족해야 합니다:

- **Java Development Kit (JDK):** 시스템에 Java가 설치되어 있어야 합니다. [Oracle 웹사이트](https://www.oracle.com/java/technologies/javase-downloads.html)에서 다운로드할 수 있습니다.

## 로컬에서 수행(Eclipse IDE)

저장소 복제:

먼저 GitHub 저장소에서 프로젝트를 내려받아야 합니다. Eclipse에서 프로젝트를 열기 위해 저장소를 복제합니다.

Eclipse가 설치되어 있지 않다면 Eclipse 다운로드 페이지에서 Eclipse IDE for Java Developers 버전을 내려받고 설치합니다.

Eclipse를 실행한 다음 다음 단계를 따릅니다:

워크스페이스 선택: Eclipse를 처음 실행할 때 워크스페이스 디렉토리를 선택합니다. 기본 설정을 그대로 사용해도 됩니다.
프로젝트 가져오기:

Eclipse에서 프로젝트를 가져옵니다.

File 메뉴에서 Import를 선택합니다.
General 아래에서 Existing Projects into Workspace를 선택하고 Next를 클릭합니다.
Select root directory에서 이전에 복제한 프로젝트 디렉토리를 선택합니다.
Finish를 클릭하여 프로젝트를 가져옵니다.
프로젝트 실행:

이제 Eclipse에서 프로젝트가 열렸습니다. 프로젝트를 실행하려면 다음 단계를 따르십시오:

프로젝트 파일을 확장하고 src 디렉토리에서 main 클래스를 찾습니다.
main 메서드가 포함된 클래스를 열고, 코드 에디터에서 오른쪽 버튼을 클릭한 다음 Run As를 선택하고 Java Application을 클릭합니다.
프로젝트가 실행됩니다.

저장소를 포크합니다.
새 브랜치를 만듭니다: git checkout -b feature/새로운-기능.
변경 사항을 커밋합니다: git commit -m '새로운 기능 추가'.
브랜치를 원본 저장소로 푸시합니다: git push origin feature/새로운-기능.
풀 리퀘스트를 생성합니다.

## 로컬에서 수행(Intellij)

저장소 복제:
동일

IntelliJ IDEA 설치 및 설정:

IntelliJ IDEA가 설치되어 있지 않다면 IntelliJ IDEA 다운로드 페이지에서 Community 또는 Ultimate Edition을 내려받고 설치합니다.

IntelliJ IDEA를 실행한 다음 다음 단계를 따릅니다:

File 메뉴에서 Open을 선택하고, 이전에 복제한 프로젝트 디렉토리를 선택합니다.
프로젝트 구성:

IntelliJ IDEA에서 프로젝트를 열면 프로젝트 구성이 시작됩니다. IntelliJ는 대부분의 Java 프로젝트 구성을 자동으로 감지하고 설정해 줍니다. 다음으로 해야 할 작업은 아래와 같습니다:

프로젝트 SDK를 설정합니다. JDK를 선택하거나 설치합니다.
프로젝트의 종속성을 다운로드하고 빌드합니다.
프로젝트 실행:

프로젝트가 IntelliJ IDEA에서 성공적으로 열렸다면, 이제 실행할 준비가 되었습니다.

프로젝트 파일을 확장하고 src 디렉토리에서 main 클래스를 찾습니다.
main 메서드가 포함된 클래스를 열고, 코드 에디터에서 오른쪽 버튼을 클릭한 다음 Run을 선택하고 해당 클래스를 클릭합니다.
프로젝트가 실행됩니다.
