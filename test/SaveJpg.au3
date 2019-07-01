$myJpg = "D:\workspace\wangtao\src\web\ui\test\1.jpg"
if FileExists ($myJpg) Then
   FileDelete ($myJpg)
EndIf
ControlFocus("另存为","","Edit1")
WinWait("[CLASS:#32770]","",5)
ControlFocus("另存为","","Edit1")
Sleep(2000)
ControlSetText("另存为","","Edit1","D:\workspace\wangtao\src\web\ui\test\1.jpg")
Sleep(2000)
ControlClick("另存为","","Button1")