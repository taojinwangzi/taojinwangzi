$myJpg = "D:\workspace\wangtao\src\web\ui\test\1.jpg"
if FileExists ($myJpg) Then
   FileDelete ($myJpg)
EndIf
ControlFocus("���Ϊ","","Edit1")
WinWait("[CLASS:#32770]","",5)
ControlFocus("���Ϊ","","Edit1")
Sleep(2000)
ControlSetText("���Ϊ","","Edit1","D:\workspace\wangtao\src\web\ui\test\1.jpg")
Sleep(2000)
ControlClick("���Ϊ","","Button1")