@echo off
setlocal enabledelayedexpansion

:: Input and temporary file paths
set "input_file=eula.txt"
set "temp_file=temp_eula.txt"

:: Ensure input file exists
if not exist "%input_file%" (
    echo Error: "%input_file%" not found.
    exit /b 1
)

:: Modify the file line by line
set /a line_count=0
> "%temp_file%" (
    for /f "tokens=* delims=" %%A in ('type "%input_file%"') do (
        set /a line_count+=1
        if !line_count! equ 3 (
            echo eula=true
        ) else (
            echo %%A
        )
    )
)

:: Replace the original file with the temporary file
move /y "%temp_file%" "%input_file%"

echo Line 3 in "%input_file%" has been updated to "eula=true".
