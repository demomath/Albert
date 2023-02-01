const hello = "Hello";
const title = hello + "，Albert World";
$view.render({
    rootView: {
        type: "verticalLayout",
        width: -1,
        height: -1,
        children: [
            {
                "type": "text",
                "width": -1,
                "height": -2,
                "text": title,
                "textSize": 6,
                "textColor": "#000000",
                "marginTop": 20,
            },
            {
                "type": "image",
                "width": -1,
                "height": -2,
                "marginTop": 80,
                "url": "https://pic4.zhimg.com/v2-956b116a3053e0eca922d84d404fb32c_1440w.jpg?source=172ae18b"
            },
            {
                "type": "button",
                "width": -1,
                "height": -2,
                "text": "点击弹出原生Toast",
                "textSize": 6,
                "marginTop": 120,
                "textColor": "#000000",
                "onClick": function() {
                    console.toast("success!");
                }
            }
        ]
    }
})