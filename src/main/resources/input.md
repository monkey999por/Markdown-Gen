aaa// これいいぞ
aaa// https://www.tohoho-web.com/js/
aaa// https://developer.mozilla.org/ja/docs/Web/JavaScript
aaa// これはECMAのドラフト？なのかな
aaa// https://www.ecma-international.org/publications-and-standards/standards/ecma-262/
aaa
aaa// ■基本
aaa// ・大文字小文字を区別
aaa
aaa
aaa// ■ 変数宣言
aaa// var：変数名重複あり、ブロックスコープを無視 ※varは基本的にスコープがくそすぎるので使用禁止
aaa// let ：変数名重複なし、ブロックスコープが有効 ES2015
aaa// const: 定数
aaa/**
aaa*
aaa* ドキュメントコメントテスト
aaa*@Param
aaa*aaaaa
aaa* 日本語とかも
aaa*/
aaalet aVal = 'A';
aaalet bVal = 'B';
aaalet ab = { aVal, bVal };
aaaconsole.log(ab); // {aVal: 'A', bVal: 'B'}
aaa
aaa// ■配列
aaaconst array = ['123', 'test']
aaa// 他の方法
aaaconst ar = Array(10); // result : (10) [empty × 10] ※この場合、10を要素に持った長さ1の配列ではなく、要素が空の長さ10の配列が生成される
aaaconst arr = [10]; // result [10] 10という要素が一つの長さ1の配列
aaa// 以上のことから、配列を作るときは[]リテラルを使用すること。Arrayだと意図しないような動きになるので。
aaaconsole.log(typeof ar); // object
aaaconsole.log(typeof arr); // object
aaaconsole.log(Array.isArray(ar)); // true
aaaconsole.log(Array.isArray(arr)); // true
aaa
aaaconsole.log(typeof ['test', 'yy']); //object
aaaconsole.log([123, 456, 789][0]); // 123
aaaconsole.log([123, 456, 789][1]); // 456
aaa
aaa// ■オブジェクト
aaaconst obj = {
aaa    x: 123,
aaa    y: 'test',
aaa    z: {
aaa        test: 'dummy'
aaa    },
aaa    // ES2015からこういう書き方もできる。
aaa    func1(){
aaa        console.log('func1');
aaa    },
aaa    // 以前の書き方
aaa    oldfunc1 : () => {
aaa        console.log('old func');
aaa    }
aaa}
aaaconsole.log(typeof obj); //object
aaaconsole.log(obj.x); // 123    ※ドット構文
aaaconsole.log(obj['y']); // y   ※ブラケット構文
aaa
aaa// ■定数の注意点
aaa//参照自体は変えられない。
aaaconst A = [1, 2, 3];
aaa//A = [] // NG
aaaA[1] = 123 // OK
aaa
aaa// ■演算子いろいろ
aaaconsole.log(typeof 123); // number
aaaconsole.log(typeof 'test'); // string
aaaclass Dummy { }
aaaconsole.log(typeof new Dummy); // object
aaa
aaaconsole.log(new Dummy instanceof Dummy); // true
aaaconsole.log('123' instanceof String); // false
aaa
aaa
aaa// ■分割代入 ES2015
aaaconst values = ['test', 'hoge', 'fuga', 'monkey'];
aaaconst [a, b, c, d] = values;
aaaconsole.log(a); // test
aaaconsole.log(d); // monkey
aaa
aaaconst [first, ...other] = values;
aaaconsole.log(first); // test
aaaconsole.log(other); // ['hoge', 'fuga', 'monkey']
aaa
aaa// ■文字列
aaa"test", 'test', `test` // テンプレートリテラル。
aaaconst variable = '999';
aaaconsole.log(`test${variable}test`); // 変数埋め込みは
aaa
aaa// ■for in
aaa// "loop with object key",
aaa//     "※オブジェクトのキーを列挙するときに使う。主にはデバッグ用らしい",
aaa//     "※要素の順番を保証しない",
aaa//     "※配列の列挙には使用しないこと。",
aaa// expected output:
aaa// "a: 1"
aaa// "b: 2"
aaa// "c: 3"
aaaconst object = { a: 1, b: 2, c: 3 };
aaafor (const property in object) {
aaa    console.log(`${property}: ${object[property]}`);
aaa}
aaa
aaa// ■forof
aaa// loop for iterable object
aaa// expected output: "a"
aaa// expected output: "b"
aaa// expected output: "c"
aaaconst array1 = ['a', 'b', 'c'];
aaafor (const element of array1) {
aaa    console.log(element);
aaa}
aaa
aaa// ■try catch
aaa// ※オーバーヘッドが高いのでforループの中で使ったりしないこと
aaa// output:
aaa// "Error"
aaa// "final"
aaatry {
aaa    throw new Error('oops');
aaa} catch (e) {
aaa    if (e instanceof Error) {
aaa        console.log('Error');
aaa    } else {
aaa        console.log('not Error');
aaa        throw e
aaa    }
aaa} finally {
aaa    console.log('final');
aaa}
aaa
aaa// ■new : instanceを作成
aaa// const name = new type(arguments);
aaa// クラスの場合
aaaclass DClass {
aaa    value = 0;
aaa    constructor(param) {
aaa        this.value = param;
aaa    }
aaa    add(num) {
aaa        if (num != null && num != null)
aaa            this.value += num
aaa        console.log(this.value);
aaa    }
aaa}
aaa
aaaconst d1 = new DClass(5);
aaad1.add();// 5
aaad1.add(100);// 105
aaaconst d2 = new DClass(10);
aaad2.add(2); // 12
aaad1.add(100);// 205
aaad2.add(10);// 22
aaa
aaa// Functionの場合
aaafunction Fn(str) {
aaa    this.str = str;
aaa    this.f = (s) => console.log(this.str + s);
aaa}
aaa
aaaconst f1 = new Fn('f1');
aaaf1.f(' f1 add') // "f1 f1 add"
aaaconst f2 = new Fn('f2');
aaaf2.f(' f2 add') // "f2 f2 add"
aaa
aaa// これはできないっぽい
aaaconst Obj = {
aaa    x: 123,
aaa    y: 456
aaa}
aaa// できない コンストラクタがないため
aaa// const ob = new Obj();
aaa// これもダメ　コンストラクタがないため
aaa// const name = new Math(); // Math is not a constructor
aaa
aaa// 余談：プロトタイプ(prototype)について
aaa// こんなことも可能:　プロトタイプのメソッドの書き換え。
aaa// https://developer.mozilla.org/ja/docs/Learn/JavaScript/Objects/Object_prototypes
aaa// この場合はObjectクラスのvalueOfが書き変わってるはず
aaaDClass.prototype.valueOf = function () { console.log('kakikae') }
aaad1.valueOf() // kakikae
aaad2.valueOf() // kakikae
aaa
aaa// ■Symbol javascript組み込みオブジェクト（StringとかNumberとかと同列。こいつだけ概念が他の言語にないので書いとく）
aaa// https://qiita.com/naruto/items/312adeb6145eb6221be7
aaalet Sym1 = Symbol("Sym")
aaalet Sym2 = Symbol("Sym")
aaa// 一旦作ったシンボルは、それ自身とのみ等しくなる。
aaaconsole.log(Sym1 === Sym2) // false
aaaconsole.log(Sym1 === Sym1); // true
aaa
aaa// ■any function
aaa// 関数定義方法いろいろ
aaa// function命令
aaafunction basicFn(params) {
aaa    console.log(params);
aaa}
aaabasicFn('basic'); // basic
aaa// Function constructor ※基本的にこの形。まず使うことはない
aaaconst FuncCon = new Function('base', 'height', 'return base * height;');
aaaconsole.log(FuncCon(10, 5)); // 50
aaa
aaa// 関数リテラル
aaa// 内部的には1.匿名関数を定義, 2.変数に代入　の流れらしい
aaaconst fnLiteral = function (params) {
aaa    console.log(params);
aaa}
aaafnLiteral('fnLiteral'); // fnLiteral
aaa
aaa// arrow function
aaa// 他の関数定義との違いとして、thisが固定される（？）
aaa// 例えばこんな感じの違い
aaa// 1.
aaa// document.addEventListener('DOMContentLoaded', () => {
aaa//     let input_zone = document.getElementById('inputs');
aaa//     input_zone.addEventListener('click', function () {
aaa//         console.log(this); // ★input_zoneが取れる
aaa//         this.classList.toggle('black');
aaa//     }, false);
aaa// }, false);
aaa
aaa// 2.
aaa// document.addEventListener('DOMContentLoaded', () => {
aaa//     let input_zone = document.getElementById('inputs');
aaa//     input_zone.addEventListener('mouseover', () => {
aaa//         console.log(this); // ★Windowがとれる　windowってなに・・
aaa//     }, false);
aaa// }, false);
aaaconst arrowFn = (args) => {
aaa    console.log(args);
aaa};
aaaarrowFn('arrowFn'); // arrowFn
aaa
aaaconsole.log(typeof basicFn); // function
aaaconsole.log(typeof FuncCon); // function
aaaconsole.log(typeof fnLiteral); // function
aaaconsole.log(typeof arrowFn); // function
aaa
aaaconsole.log(basicFn instanceof Function); // true
aaaconsole.log(FuncCon instanceof Function); // true
aaaconsole.log(fnLiteral instanceof Function); // true
aaaconsole.log(arrowFn instanceof Function); // true
aaa
aaa// 引数の参照について
aaalet value = 123
aaalet refvalue = { x: 123, y: 456 };
aaa// 即時関数（定義と同時に実行）
aaa(function (val, refval) {
aaa    val = 000
aaa    refval.x = 999
aaa}(value, refvalue));
aaa
aaaconsole.log(value); // 123 ※基本データ型の場合
aaaconsole.log(refvalue); // 999　※参照型
aaa
aaa// 可変長引数 Argumentsオブジェクト
aaafunction test() {
aaa    console.log(`arguments.length : ${arguments.length}`); // 4
aaa    for (const iterator of arguments) {
aaa        console.log(iterator);
aaa    }
aaa}
aaatest(1, 2, 3, 4);// 1,2,3,4
aaa
aaa// 名前付き引数 関数呼び出し時に引数名を明記
aaa// メリット：呼び出し時に引数の順番を変えて呼び出せる（中間の引数だけに値を与えることも可能
aaafunction show({ name = '設定されていません', age = 0 }) {
aaa    console.log('名前　' + name);   // 名前　Lowell
aaa    console.log('年齢　' + age);    // 年齢　34
aaa}
aaashow({ age: 34, name: 'Lowell' });
aaa
aaa// default arguments
aaafunction defaultArgs(param = 10) {
aaa    console.log(param);
aaa}
aaadefaultArgs() // 10
aaadefaultArgs(99) // 99
aaa// こんなこともできる
aaafunction da(param = 5, nextParam = param) {
aaa    console.log(param);
aaa    console.log(nextParam);
aaa}
aaa
aaada() // 5; 5;
aaada(10) // 10;10;
aaada(1, 2) // 1; 2;
aaa
aaa// 例えば引数の必須チェックをしたいときはこんなやり方もある
aaaclass NoArgumentError extends Error { }
aaa
aaafunction requireArg() {
aaa    throw new NoArgumentError('argument was not given');
aaa}
aaafunction da(param = requireArg()) {
aaa    console.log(param);
aaa}
aaada('test'); // test
aaada(); // Uncaught Error: argument was not given
aaa
aaa// 関数の引数は未指定の場合はundefinedが自動で渡される。エラーにはならない。
aaa// オーバーロード的なことはできないため、下の二つは同時に定義できない　：Identifier 'testa' has already been declared (at main.js:16:1)
aaa// function testa(p1) {
aaa//     console.log(p1);
aaa
aaa// }
aaa
aaa// function testa(p1,p2) {
aaa//     console.log(p1);
aaa//     console.log(p2);
aaa// }
aaa
aaa
aaa// タグ付きテンプレート文字列
aaafunction tagTemplateStr(template, ...value) {
aaa    console.log(template); // ['A ', ' ', ' D'] // 配列で保持してるっぽい
aaa    return template[0] + value[0] + value[1] + template[2];
aaa}
aaa
aaaconst value1 = 'B'
aaaconst value2 = 'C'
aaaconsole.log(tagTemplateStr`A ${value1} ${value2} D`); // A BC D
aaa
aaa// クロージャ P217あたり　変数のスコープの話も書いてて勉強になる。
aaafunction closure(arg) {
aaa    let val = arg;
aaa    return function () {
aaa        return ++val;
aaa    }
aaa}
aaa// returnしている無名関数が関数内に定義した変数valへの参照を維持している状態(変数valはclosureの中で保持されている)
aaalet myClorure = closure(0);
aaaconsole.log(myClorure()); // 1
aaaconsole.log(myClorure()); // 2
aaaconsole.log(myClorure()); // 3
aaa
aaa// その他
aaa// これとか面白い　カンマが演算子としてどう評価されるか
aaa// https://developer.mozilla.org/ja/docs/Web/JavaScript/Reference/Operators/Comma_Operator
aaa
aaa
aaa// name?　みたいなやつ　オプショナルチェーン
aaa// https:developer.mozilla.org/ja/docs/Web/JavaScript/Reference/Operators/Optional_chaining
aaalet test = {
aaa    val: 1,
aaa    nv: null
aaa}
aaa// test?.val ?? 'default'　この書き方は多分よく使うので覚えとけ。スニペットに登録
aaaconsole.log(test?.val ?? 'default'); // 1
aaaconsole.log(test?.nv ?? 'default'); // default
aaaconsole.log(test?.aaa ?? 'default'); // default
aaa
aaa// Promise
aaa//　ちょっとよくわからんので後でちゃんと調べよう
aaaasync function runMain(event) {
aaa
aaa    // https://developer.mozilla.org/ja/docs/Web/JavaScript/Reference/Global_Objects/Promise
aaa    console.log('start main thread');
aaa
aaa    const myPromise = new Promise((resolve, reject) => {
aaa        setTimeout(() => {
aaa            resolve('foo');
aaa        }, 300);
aaa    });
aaa
aaa    myPromise.then(myResolve, myReject).catch(myCatch);
aaa
aaa    function myResolve(params) {
aaa        console.log('resolve');
aaa    }
aaa    function myReject(params) {
aaa        ;
aaa        console.log('reject');
aaa    }
aaa
aaa    function myCatch(params) {
aaa        console.log('cathc');
aaa    }
aaa
aaa    console.log('end main thread');
aaa}
aaa
aaa// この辺の組み込みオブジェクトは後で見とく
aaa// Array,Map,Set,Date,Math,RegExp,Object,Promise、Proxy
aaa// https://developer.mozilla.org/ja/docs/Web/JavaScript/Reference/Global_Objects
aaa
aaa
aaa// P358 オブジェクトの内部仕様的なやつのメモ
aaa//ブラウザオブジェクトの階層ってこんな感じ
aaa/**
aaa * Windowオブジェクト(global object). property : parent, self, top, window(Windowオブジェクトへの参照)
aaa * ├─document(Documentオブジェクト)
aaa * │  ├─forms(Formオブジェクトの配列)
aaa * │  ├─anchors(Ancorオブジェクトの配列)
aaa * │  └─images(imageオブジェクトの配列)
aaa * ├─console(Consoleオブジェクト)
aaa * ├─localStrage/sessionStrage(Strageオブジェクト)
aaa * ├─location(Locationオブジェクト)
aaa * ├─history(Historyオブジェクト)
aaa * ├─navigator(Navigatorオブジェクト)
aaa * └─XMLHttpRequest/FileReader(Workerオブジェクト)
aaa */
aaa// 実際に使うときは以下のようにする
aaaconsole.log('test');
aaa// これも意味は同じ(Windowオブジェクトの持つwindowプロパティ(Windowsオブジェクトへの参照を持つ)を介してアクセス）
aaawindow.console.log('test');
aaa// Window.console.log('test'); // これはNG. Windowsオブジェクトの直接参照はできない
aaa
aaa/**
aaa * new演算子について(ここみればだいたいわかる。要はclass or functionをもとにインスタンスを生成している)
aaa * https://developer.mozilla.org/ja/docs/Web/JavaScript/Reference/Operators/new
aaa */
aaa
aaa//論理演算氏の動きはちゃんと書いとくか
aaa
aaa
aaa
aaa
aaa
aaa
aaa
aaa
aaa
