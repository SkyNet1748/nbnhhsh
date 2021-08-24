# [NBNHHSH](https://github.com/gnuf0rce/nbnhhsh)

> 基于 [Mirai Console](https://github.com/mamoe/mirai-console) 的 内容分析插件 插件

[![Release](https://img.shields.io/github/v/release/gnuf0rce/nbnhhsh)](https://github.com/gnuf0rce/nbnhhsh/releases)
[![Downloads](https://img.shields.io/github/downloads/gnuf0rce/nbnhhsh/total)](https://shields.io/category/downloads)
[![MiraiForum](https://img.shields.io/badge/post-on%20MiraiForum-yellow)](https://mirai.mamoe.net/)

## 指令

注意: 使用前请确保可以 [在聊天环境执行指令](https://github.com/project-mirai/chat-command)  
带括号的`/`前缀是可选的  
`<...>`中的是指令名，由空格隔开表示或，选择其中任一名称都可执行例如`/hhsh yyds gkd`  
`[...]`表示参数，当`[...]`后面带`?`时表示参数可选  
`{...}`表示连续的多个参数

### HHSHCommand

| 指令              | 描述         |
|:------------------|:-------------|
| `/<hhsh> {words}` | 分析拼音缩写 |

回复消息会自动填充 `words`  
赋予群(`g*`, `g12345`, ...), 权限会自动触发指令  

## 设置

位于`Mirai-Console`运行目录下的`config/nbnhhsh`文件夹下

### AutoTranConfig.yml

* `pattern` 自动匹配的正则表达式
* `exclude` 自动匹配的排除项