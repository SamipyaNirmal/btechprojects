import java.applet.*;

import java.awt.*;

public class ImageGrpcsEx extends Applet

  {

    Image pic;

    public void init()

      {

        pic =getImage(getDocumentBase(),"start.png");

      }

    public void paint(Graphics grp)

      {

        grp.drawImage(pic, 50,50,this);

      }

  }

/*

<applet code="ImageGrpcsEx.class" width="400" height="400">

</applet

*/