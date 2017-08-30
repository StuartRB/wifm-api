package com.watchitforme.Item;

class ItemFactory {

    public static Item GetItemTypeByUrl(String url)
    {
        if(url.toLowerCase().indexOf("amazon.co.uk") > 0 ){
            return new AmazonItem(url);
        }
        if(url.toLowerCase().indexOf("ao.com") > 0 ){
            return new AoItem(url);
        }
        if(url.toLowerCase().indexOf("argos.co.uk") > 0 ){
            return new ArgosItem(url);
        }
        if(url.toLowerCase().indexOf("bt.com") > 0 ){
            return new BTItem(url);
        }
        if(url.toLowerCase().indexOf("debenhams.com") > 0 ){
            return new DebenhamsItem(url);
        }
        if(url.toLowerCase().indexOf("currys.co.uk") > 0 ){
            return new CurrysItem(url);
        }
        if(url.toLowerCase().indexOf("diy.com") > 0 ){
            return new BAndQItem(url);
        }
        if(url.toLowerCase().indexOf("game.co.uk") > 0 ){
            return new GameItem(url);
        }
        if(url.toLowerCase().indexOf("halfords.com") > 0 ){
            return new HalfordsItem(url);
        }
        if(url.toLowerCase().indexOf("homebase.co.uk") > 0 ){
            return new HomebaseItem(url);
        }
        if(url.toLowerCase().indexOf("houseoffraser.co.uk") > 0 ){
            return new HouseOfFraserItem(url);
        }
        if(url.toLowerCase().indexOf("johnlewis.com") > 0 ){
            return new JohnLewisItem(url);
        }
        if(url.toLowerCase().indexOf("mamasandpapas.com") > 0 ){
            return new MamasAndPapasItem(url);
        }
        if(url.toLowerCase().indexOf("marksandspencer.com") > 0 ){
            return new MarksAndSpencerItem(url);
        }
        if(url.toLowerCase().indexOf("pcworld.co.uk") > 0 ){
            return new PCWorldItem(url);
        }
        if(url.toLowerCase().indexOf("smythstoys.com") > 0 ){
            return new SmythsItem(url);
        }
        if(url.toLowerCase().indexOf("tesco.com") > 0 ){
            return new TescoItem(url);
        }
        if(url.toLowerCase().indexOf("toysrus.co.uk") > 0 ){
            return new ToysRUsItem(url);
        }
        throw new ItemNotFoundException("Unable to determine vendor");
    }
}
