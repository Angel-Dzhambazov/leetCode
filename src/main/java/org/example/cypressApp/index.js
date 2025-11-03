const { mouse, Point } = require("@nut-tree-fork/nut-js");

(async () => {

    while (true) {
        const pos = await mouse.getPosition();
        await mouse.setPosition(new Point(pos.x + 5, pos.y + 5));
        await new Promise(r => setTimeout(r, 5000));
        await mouse.setPosition(new Point(pos.x, pos.y));
        await new Promise(r => setTimeout(r, 5000));
    }
})();