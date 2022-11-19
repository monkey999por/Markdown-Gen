@echo off
@pushd %~dp0

echo %1
echo %2
pushd ..\out\artifacts\Markdown_Gen_jar
cd
java -jar Markdown-Gen.jar %1 %2

popd