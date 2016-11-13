package in.leob.one.bean;

import java.io.Serializable;

/**
 * @author leobin
 * @time 2016/11/10  14:36
 * @desc 文章数据的封装
 */
public class Article {

    private ContentEntityBean contentEntity;
    /**
     * contentEntity : {"strLastUpdateDate":"2016-11-08 15:59:39","strContent":"1<br>\r\n孟有武是外卖快递员，一单五块钱，每天从早上九点到晚上十点，生意好的时候能送五六十单，淡季二十多单，平均下来每天三十多单的样子。所送区域是五公里以内，孟有武骑着后面装着黑色外卖箱的摩托车，每个月要跑五千多公里。订餐的女性居多，每天能遇到十几个，年龄大多在二三十岁。排除重复订餐的，在八个月的时间内，他把外卖送到了四千一百多次异性手中。她们会因时间晚了脸上不悦抱怨几句，但大多情况表现冷漠，并不愿说出\u201c谢谢\u201d两字。时间长了，孟有武并不在意，即便是偶尔在电话中被辱骂，他也会及时调整好心态，迎接下一个。老员工告诉孟有武，在送餐的过程中，不要把自己当一个拥有七情六欲的人类，你只是个工具，和胯下的摩托车没有两样。你不能说孟有武是个杰出的快递员，但他有着基本的底线。这体现在被客人辱骂后，下次送餐时他不会悄悄打开饭盒，朝里面吐口水和扔几粒鼻屎进去。对于风雨无阻薪水微薄的他们，你还能奢求些什么呢。<br>\r\n <br>\r\n孟有武还记得第一次给王惠送餐的情形。六月份，天气刚开始热起来，上午孟有武在街边抽了五六根烟，杯子续了两次水，他打算买盒防晒霜，却又觉得没必要，日渐黝黑的皮肤不恰好说明自己的勤劳吗。同事马某找孟有武说了会话，并抽了他两根烟，这让孟有武心有不悦。烟是次要的话，上个月马某借了孟有武一千块钱，说好过几天就还，到现在还没还。起初马某还找借口，说手头紧，过几天就给，后来又说钱在卡里会马上给，可也没给。如今呢，马某连推辞都懒得想了，只是说没钱。他在等孟有武放弃。一千块，孟有武要干一个星期送二百次外卖。马某坐在孟有武的摩托车上，对着后视镜摆弄自己头发稀疏的脑袋，他揉搓了下脸颊，又找了几个角度端详一阵。<br>\r\n <br>\r\n孟有武问，钱你打算什么时候给。<br>\r\n马某听到了，可没任何反应，他在打赌孟有武是否会再说一遍。<br>\r\n孟有武伸手戳了下马某的肩膀，钱什么时候还？<br>\r\n没办法回避了，马某笑起来，小孟，你放心，钱我会给你的。<br>\r\n孟有武，那你现在给我吧。<br>\r\n马某笑起来，今天给不了。<br>\r\n孟有武，为什么呢。<br>\r\n马某，我没钱。<br>\r\n孟有武，你的钱呢。<br>\r\n马某，我的钱都在卡里。<br>\r\n孟有武，我跟你去银行取钱的。<br>\r\n马某摸着自己的头，今天有点热。<br>\r\n孟有武，你的卡是哪个银行的。<br>\r\n马某，我的卡。<br>\r\n孟有武，哪个银行都行，我骑着摩托车带你去。<br>\r\n <br>\r\n马某的手机响了一下，他看了眼手机，脸上露出欣喜的表情，走下摩托车，拍着孟有武的肩膀，显得亲密，孟有武往外躲了下。<br>\r\n <br>\r\n马某笑起来，小孟你没女朋友吧。<br>\r\n孟有武没说话。<br>\r\n马某，这单个让给你，不远。<br>\r\n孟有武，什么意思。马某，到时候你就知道了。<br>\r\n孟有武，你不去银行取钱的吗。<br>\r\n马某，下午人少不用排队。<br>\r\n孟有武，自动取款机还用排队吗。<br>\r\n马某，我的是存折。<br>\r\n孟有武，取款机也能用存折。<br>\r\n马某，是吗，我不知道。<br>\r\n孟有武，现在你知道了吧。<br>\r\n马某，知道了，等我送完外卖。<br>\r\n <br>\r\n王惠二十九岁，身高一米七二，体重不到五十公斤。她之前在广告公司做文案，辞职已有两月，每日在租处看书看电影，陪着她的还有一只唤作童的猫。她基本不做饭，多数时候叫外卖，偶尔出去觅食。离异多年的父母，在家乡武汉各自生活。父亲有时打来电话，问下近况，并不多言，多数以沉默表达爱意。王惠有双大眼睛，像是在纸张上挖出的两个洞，鼻子高挺，她拍照习惯将镜头放在脑门以上，看不出下巴，让鼻子更加凸显，而眼睛，让人联想到少不更事的婴儿。朋友们对王惠的一致评价是，她，还只是个孩子啊。<br>\r\n <br>\r\n十一点过五分，孟有武提着装有青椒肉丝饭的外卖箱，站在何厝小区6栋1103室的门外。他敲门，门开了一道缝，王惠露出半张脸。孟有武没说话，示意了下手里的外卖箱。他把外卖箱放在地上，打开，拿出外卖，站起来，双手递给王惠。王惠打开门，接住，然后那只唤作童的猫，跑出来，往楼梯的方向跑去。等他俩反应过来，猫已不见踪影。王惠追了过去。这时孟有武发现，王惠穿着单薄的睡衣，下身的睡裤，和内裤的尺寸相仿，上身的吊带，因薄，肉体尽显。等王惠抱着猫回来时，孟有武没走。他站在门口，一只脚挡住防盗门。王惠意识到自己的穿着，低着头，把猫抱在胸前，用来遮挡。孟有武推开门，让王惠走进去。王惠转身关门，发现孟有武的脚并没有收回。两个人目光交汇。<br>\r\n <br>\r\n孟有武说，马某让我来的。<br>\r\n王惠问，谁。孟有武说，马某，他之前给你送过外卖。<br>\r\n王惠哦了一声，我不认识她。<br>\r\n孟有武说，这单也本应该他来送。<br>\r\n王惠问，然后，你什么意思。<br>\r\n孟有武说，我有个问题，想找人谈谈。<br>\r\n <br>\r\n2<br>\r\n我把上面的文字发给王惠看，并告诉她，原本我起的题目是《外卖员孟有武的一次爱情经历》，但似乎整个故事谈不上爱情，后来又改成《外卖员孟有武的一次情感经历》，可又似乎欠缺点味道，那么《外卖员孟有武的一次性爱经历》合适吗？<br>\r\n王惠说，这有点生猛，不过也行。<br>\r\n我说，我已经决定让你和孟有武发生性关系了。<br>\r\n王惠说，希望孟有武长得好看。<br>\r\n <br>\r\n孟有武这个人物的原型是我的一个朋友，他比王惠大两岁，身高比王惠矮两公分，长得不难看，却也称不上帅气，性格沉稳，不太爱讲话，嘴唇厚，颧骨有些高，和人讲话时因害羞会露出微笑。当然这些我没告诉王惠，作为一个长期独居的年轻女性，不应该留给她更多的想象空间吗。<br>\r\n <br>\r\n王惠说她在夏天接外卖的时候确实穿睡衣，不应该说是暴露，性感会更具体一点。因为开门拿了外卖后就立刻关门，也就不顾忌这么多了。这说明我们的王惠，是个不拘小节思想开放的年轻人，这从她书架上的书有所体现，比如《性审判史》《无限接近于透明的蓝》《肠子》《人类尸体的奇异生活》。<br>\r\n <br>\r\n我问王惠，还有一个细节，你接外卖的时候，猫会跑出去吗。<br>\r\n王惠说，那倒不会，它就在家里，因为它小时候跑出去过一次，找了一天才找到，后来就再也不敢往外面跑了。<br>\r\n我问，你是在哪里找到的童。<br>\r\n王惠说，这只猫是好朋友上个月才送到我这里的，是她在楼下找到的。<br>\r\n <br>\r\n3<br>\r\n王惠换上衣服，从卧室走出来。孟有武站在门口，打量着房间，墙壁上贴着印有黄色星星和月亮的淡蓝色壁纸，一张铺着蓝红相间床单的双人床，枕头位置放着几个毛绒玩具和一个写有\u201c女神\u201d两字的红色抱枕，床头柜和书架都是原木色的，上面放着几个画框，图案为插画，角落里是落地台灯，灯罩是蓝红黄三色。独身异性的闺房，让孟有武有些无从落脚，房间整洁，缺乏脏乱差的生活气息，这让本身不爱打理的他，有些心虚。等孟有武回过神来，王惠已经开饭，用筷子往嘴里扒拉。<br>\r\n <br>\r\n孟有武问，你很饿吗。<br>\r\n王惠说，早饭没吃。<br>\r\n孟有武问，一份能吃饱吗。<br>\r\n王惠说，今天的分量有点多。<br>\r\n孟有武说，我让他们多盛了些。<br>\r\n王惠低着头吃，你找个凳子坐下吧。<br>\r\n孟有武坐下，离王惠三米多的距离，因空间的狭小，显得疏远。<br>\r\n <br>\r\n王惠说，说吧。<br>\r\n孟有武问，说什么。<br>\r\n王惠说，你不是有问题要谈吗。<br>\r\n孟有武有些犹豫，本来想和你谈的，但又觉得和陌生人谈钱这个话题，有些不合适。<br>\r\n王惠放下筷子，看着孟有武，眼神流露出惊恐，你要干什么，我没钱，我已经两个月没工作了，正打算下个星期去找工作。<br>\r\n <br>\r\n孟有武站起来，两只手展开在空中摆动。王惠吓坏了，往回退，不小心摔在地上，迅速爬起来，去寻找什么，她跳到床上，从枕头下面拿起一把手工刀，刀柄长，刀刃短，刀刃因平时用来割快递包裹的胶带，有些发粘。<br>\r\n <br>\r\n孟有武看着王惠的举动，辩解，你误会了，我没那个意思。<br>\r\n王惠站在床上，你过来我就扎你。<br>\r\n孟有武笑起来，你冷静点好不好。<br>\r\n王惠说，操你妈你才需要冷静，你给我滚出去。<br>\r\n孟有武往后退，退到门边，你让我说完，行吗。<br>\r\n王惠说，赶紧说完滚出去。<br>\r\n孟有武说，马某欠我钱，他总是不给我，然后让我来送这单，说等我送完这单，就明白了，我想你应该知道他为什么不给我钱。<br>\r\n王惠一脸的疑问，我他妈的根本不认识马某，他不给你钱，你找他要啊，找我干什么，我也没钱，就算有，我不给你还打算硬抢啊。<br>\r\n孟有武说，我没打算抢，你说我该怎么办。<br>\r\n王惠说，这还不好办，他不给，你他妈的去抢他啊。<br>\r\n孟有武笑起来。<br>\r\n <br>\r\n4<br>\r\n现实中王惠有过危险逼近的经历，反抗措施是自杀式威胁。考虑到她尚在人间，说明她遇到的并非是穷凶极恶之徒。一个不积极主动寻求机会性格孤僻的单身女性，在面对入室抢劫时，她的回答是，抢就抢吧，我大概是不会想着去自救的。而你只有在发生重大事件时，才看清自身的懦弱，不敢反抗，把所有解决问题的希望放在自我毁灭这一条路上。死是解决任何的问题的终极途径。王惠这样的一个人，不排除在其火葬时噌噌出舍利子的可能性。<br>\r\n <br>\r\n5<br>\r\n在孟有武描述到秃头时，王惠终于把马某这个名字和人联系到了一起。王惠说她对马某这个人确实没什么好印象，来给她送过两三次外卖，总是在笑，色眯眯的样子。说到这里，孟有武笑起来。<br>\r\n <br>\r\n王惠说，你也没比他好到哪里去，不苟言笑，阴森森的，像是个变态。<br>\r\n孟有武说，怎么听起来还不如马某呢。<br>\r\n王惠把掉在地上的盒饭捡起来，扔进垃圾桶里。<br>\r\n孟有武说，你平时外卖都点什么。王惠说，青椒肉丝饭，黄焖鸡米饭，皮蛋瘦肉粥，大概就这三样。<br>\r\n孟有武说，其实你应该相信我的，如果我对你有想法，在外卖里下药岂不更省事。<br>\r\n王惠说，可是我一般接到外卖，立刻关门，你下药也没用啊。<br>\r\n孟有武说，如果我会开锁呢。<br>\r\n王惠说，但是楼道里有监控，送外卖都会有记录，你跑不了。<br>\r\n孟有武笑起来，既然我都打算犯罪了，我还担心被抓住接受法律的制裁吗。<br>\r\n王惠想了会，你说得很有道理。<br>\r\n <br>\r\n手机响了，孟有武没有看。<br>\r\n王惠说，你不看吗。<br>\r\n孟有武说，有外卖。<br>\r\n王惠说，你不接单吗。<br>\r\n孟有武说，先不接了，我还有个问题和你谈。<br>\r\n王惠叹了口气，你还要谈什么。<br>\r\n孟有武说，谈谈你吧。<br>\r\n王惠笑起来，我有什么好谈的。<br>\r\n孟有武问，你有男朋友吗。<br>\r\n王惠说，没有。<br>\r\n孟有武说，昨天男朋友和我提分手了。说完，孟有武苦笑了一下，低着头。<br>\r\n王惠想了会，你是同性恋啊，放心，我不会歧视你的。<br>\r\n孟有武抬起头，看着王惠，你这话本身就带有歧视色彩。<br>\r\n王惠摆手，没有，我就是怕你多想。<br>\r\n孟有武说，既然我告诉你，就不怕你歧视我，你没必要掩饰自己，歧视我也可以理解。<br>\r\n王惠站起来，挠着头，我怎么和你说不明白呢，我没歧视你的意思。她拿起手工刀，我真想一刀扎死你。<br>\r\n孟有武说，你这么气急败坏干什么，刚才说不歧视我，现在连扎死我的心都有了。<br>\r\n王惠耷拉着脑袋，好，我歧视你行了吧，这样你满意了吧。<br>\r\n <br>\r\n两个人一阵沉默，各自偷瞄对方，又闪避对方的目光。此时，王惠在犹豫是否讲下自己的事情，作为对方诚实相告是同性恋的一种平等交换。如果说听者有另外的念头，那不在王惠的设想之内，她只是觉得有必要说一下，倾诉也罢。<br>\r\n <br>\r\n一次短暂失败的婚姻，让王惠有些轻微的抑郁，表现在失眠和不愿与人沟通。失眠这件事她已经有些习惯，当然身心俱疲是难以避免的。至于沟通，现实中王惠只和一两个之前的女同事，还有联系。作为外来务工人员，抱团取暖是应有之义。王惠把话唠和幽默的一面通过网络展示给分散于祖国各地的朋友，她善用各式表情包，对东北方言驾轻就熟。因王惠旅居厦门，前些年时常有外地的网友来找她当向导和陪同，在著名的小清新景点拍照留念。近几年，情况减少，倒不是众人对小清新失去了兴致。而是王惠厌倦了，她本身也不是热爱走动的人，让并不牢固的友谊来为难自己，没有这种必要了吧。无一例外，那些被王惠接待过的朋友，在短暂的交往后不再联系，变成一个个冰冷的网络代码。王惠的理想职业是当个图书管理员，守着万卷，闲来无事抽出一本读一读。碰到合意的，拍照发在网上。最近，她发布的照片是《木心回忆录》里对十九世纪俄国文学的介绍。原文如下：尤其是《奥勃洛莫夫》，哄传一时，写出一个典型：人不坏，甚而很好，可是一味的懒，有思想，没行动，连女人、爱情也刺激不了他，只想躺在沙发上。<br>\r\n <br>\r\n讲完自己的故事，王惠说，该你了。<br>\r\n孟有武笑起来，我什么。<br>\r\n王惠说，你和你男朋友的事啊。<br>\r\n孟有武说，有件事我得和你坦白，我不是同性恋。<br>\r\n王惠生气了，站起来，你这人不坦诚啊。<br>\r\n孟有武说，我只是想接近你的内心。<br>\r\n王惠问，你想怎样。<br>\r\n孟有武说，不瞒你说，我很久没和女的说这么长时间话了。<br>\r\n王惠叹了口气，有件事我也得和你坦白，我性冷淡。<br>\r\n孟有武上下打量着王惠，不可能，你怎么可能性冷淡呢。<br>\r\n王惠说，我怎么不会呢，我离婚就是因为这个。<br>\r\n孟有武说，我还是不信。<br>\r\n王惠生气了，操，不信，就试试。<br>\r\n孟有武站起来，试试就试试，我还怕你不成。<br>\r\n三分钟后，孟有武从王惠的身上下来，坐在床沿上低着头说，你怎么一点反应都没有呢。<br>\r\n王惠拍了下孟有武的后背，哥们，别灰心，是我个人原因。<br>\r\n孟有武拿起床头柜上的手工刀，这个，我借用下。<br>\r\n <br>\r\n6<br>\r\n孟有武坐在站点外，烈日当空，他抽着烟，整个口腔在冒火。马某骑着摩托车从远处过来。孟有武站起来。马某心情不错，下车走过来，怎么样，要感激我吧。孟有武掏出手工刀，对准马某。<br>\r\n <br><br><br><b>写小说。短篇小说集《小镇忧郁青年的十八种死法》。<\/b>","sWebLk":"http://m.wufazhuce.com/article/1584","wImgUrl":"http://image.wufazhuce.com/FrrwRWZ-VGdJh-Yv11djBZKHjzF9","sRdNum":"132856","strPraiseNumber":"725","strContDayDiffer":"","strContentId":"1584","strContTitle":"外卖员孟有武的一次性爱经历","strContAuthor":"魏思孝","strContAuthorIntroduce":"（责任编辑：卫天成 weitiancheng@wufazhuce.com）","strContMarketTime":"2016-11-10","sGW":"老员工告诉孟有武，在送餐的过程中，不要把自己当一个拥有七情六欲的人类，你只是个工具，和胯下的摩托车没有两样。","sAuth":"写小说。短篇小说集《小镇忧郁青年的十八种死法》。","sWbN":"","subTitle":""}
     * result : SUCCESS
     */

    private String result;

    public Article(ContentEntityBean contentEntity) {
        this.contentEntity = contentEntity;
    }

    public ContentEntityBean getContentEntity() {
        return contentEntity;
    }

    public void setContentEntity(ContentEntityBean contentEntity) {
        this.contentEntity = contentEntity;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static class ContentEntityBean implements Serializable{
        private String strContent;//文章内容
        private String sWebLk;//文章链接
        private String strContTitle;//文章标题
        private String strContAuthor;//文章作者
        private String strContMarketTime;//文章时间
        private String sGW;//内容摘要
        private String strContAuthorIntroduce;//责任编辑

        public String getStrContent() {
            return strContent;
        }

        public void setStrContent(String strContent) {
            this.strContent = strContent;
        }

        public String getSWebLk() {
            return sWebLk;
        }

        public void setSWebLk(String sWebLk) {
            this.sWebLk = sWebLk;
        }

        public String getStrContTitle() {
            return strContTitle;
        }

        public void setStrContTitle(String strContTitle) {
            this.strContTitle = strContTitle;
        }

        public String getStrContAuthor() {
            return strContAuthor;
        }

        public void setStrContAuthor(String strContAuthor) {
            this.strContAuthor = strContAuthor;
        }

        public String getStrContMarketTime() {
            return strContMarketTime;
        }

        public void setStrContMarketTime(String strContMarketTime) {
            this.strContMarketTime = strContMarketTime;
        }

        public String getStrContAuthorIntroduce() {
            return strContAuthorIntroduce;
        }

        public void setStrContAuthorIntroduce(String strContAuthorIntroduce) {
            this.strContAuthorIntroduce = strContAuthorIntroduce;
        }

        public String getsGW() {
            return sGW;
        }

        public void setsGW(String sGW) {
            this.sGW = sGW;
        }

        public ContentEntityBean(String strContent, String sWebLk, String strContTitle,
                                 String strContAuthor, String strContMarketTime, String sGW, String strContAuthorIntroduce) {
            this.strContent = strContent;
            this.sWebLk = sWebLk;
            this.strContTitle = strContTitle;
            this.strContAuthor = strContAuthor;
            this.strContMarketTime = strContMarketTime;
            this.sGW = sGW;
            this.strContAuthorIntroduce = strContAuthorIntroduce;
        }
    }
}
