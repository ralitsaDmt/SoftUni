function tripLength([x1, y1, x2, y2, x3, y3]) {

    function findDistance(x1, y1, x2, y2) {
        let dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return dist;
    }

    let dist12 = findDistance(x1, y1, x2, y2);
    let dist23 = findDistance(x2, y2, x3, y3);
    let dist13 = findDistance(x3, y3, x1, y1);

    if(Math.max(dist12,dist13, dist23) == dist13) console.log(`1->2->3: ${dist12+dist23}`)
    else if(Math.max(dist12,dist13, dist23) == dist12) console.log(`1->3->2: ${dist13+dist23}`)
    else if(Math.max(dist12,dist13, dist23) == dist23) console.log(`2->1->3: ${dist12+dist13}`);
}

tripLength([-1, -2, 3.5, 0, 0, 2]);