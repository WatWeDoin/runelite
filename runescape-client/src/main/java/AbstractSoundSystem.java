import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("r")
   @Export("highMemory")
   public static boolean highMemory;
   @ObfuscatedName("z")
   public static class103 field1660;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2063185177
   )
   @Export("priority")
   public static int priority;
   @ObfuscatedName("ay")
   class119[] field1662;
   @ObfuscatedName("x")
   boolean field1661;
   @ObfuscatedName("l")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("c")
   class119 field1658;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -251211725
   )
   int field1655;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 798144963
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1586136121
   )
   int field1651;
   @ObfuscatedName("ar")
   class119[] field1663;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 8239453261365514039L
   )
   long field1656;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -2408593945972820735L
   )
   long field1652;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2138949941
   )
   int field1657;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 391816263
   )
   int field1659;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2010026685
   )
   int field1654;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1776242139
   )
   int field1646;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -5390763764117575927L
   )
   long field1666;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1406365803
   )
   int field1650;

   protected AbstractSoundSystem() {
      this.field1651 = 32;
      this.field1652 = DState.currentTimeMs();
      this.field1656 = 0L;
      this.field1657 = 0;
      this.field1654 = 0;
      this.field1659 = 0;
      this.field1666 = 0L;
      this.field1661 = true;
      this.field1655 = 0;
      this.field1663 = new class119[8];
      this.field1662 = new class119[8];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "65497601"
   )
   protected void vmethod2034() throws Exception {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   protected void close() {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1259339403"
   )
   public final synchronized void method2022() {
      if(this.samples != null) {
         long var1 = DState.currentTimeMs();

         try {
            if(this.field1656 != 0L) {
               if(var1 < this.field1656) {
                  return;
               }

               this.create(this.offset);
               this.field1656 = 0L;
               this.field1661 = true;
            }

            int var3 = this.size();
            if(this.field1659 - var3 > this.field1657) {
               this.field1657 = this.field1659 - var3;
            }

            int var4 = this.field1646 + this.field1650;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.offset) {
               this.offset += 1024;
               if(this.offset > 16384) {
                  this.offset = 16384;
               }

               this.close();
               this.create(this.offset);
               var3 = 0;
               this.field1661 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1646 = var4 - this.field1650;
               }
            }

            while(var3 < var4) {
               this.method2059(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1666) {
               if(!this.field1661) {
                  if(this.field1657 == 0 && this.field1654 == 0) {
                     this.close();
                     this.field1656 = 2000L + var1;
                     return;
                  }

                  this.field1646 = Math.min(this.field1654, this.field1657);
                  this.field1654 = this.field1657;
               } else {
                  this.field1661 = false;
               }

               this.field1657 = 0;
               this.field1666 = 2000L + var1;
            }

            this.field1659 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1656 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1652) {
               var1 = this.field1652;
            }

            while(var1 > 5000L + this.field1652) {
               this.method2026(256);
               this.field1652 += (long)(256000 / FileSystem.sampleRate);
            }
         } catch (Exception var6) {
            this.field1652 = var1;
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1370558022"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-27"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "718886195"
   )
   public final synchronized void method2024() {
      this.field1661 = true;

      try {
         this.vmethod2034();
      } catch (Exception var2) {
         this.close();
         this.field1656 = DState.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1403221396"
   )
   final void method2026(int var1) {
      this.field1655 -= var1;
      if(this.field1655 < 0) {
         this.field1655 = 0;
      }

      if(this.field1658 != null) {
         this.field1658.vmethod3885(var1);
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-1923290509"
   )
   final void method2063(class119 var1, int var2) {
      int var3 = var2 >> 5;
      class119 var4 = this.field1662[var3];
      if(var4 == null) {
         this.field1663[var3] = var1;
      } else {
         var4.field1727 = var1;
      }

      this.field1662[var3] = var1;
      var1.field1728 = var2;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "5015"
   )
   public final synchronized void method2025() {
      if(class157.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class157.task.systems[var2]) {
               class157.task.systems[var2] = null;
            }

            if(class157.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class170.field2356.shutdownNow();
            class170.field2356 = null;
            class157.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1141738991"
   )
   public final void method2062() {
      this.field1661 = true;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method2059(int[] var1, int var2) {
      int var3 = var2;
      if(highMemory) {
         var3 = var2 << 1;
      }

      class183.method3441(var1, 0, var3);
      this.field1655 -= var2;
      if(this.field1658 != null && this.field1655 <= 0) {
         this.field1655 += FileSystem.sampleRate >> 4;
         WorldMapType2.method525(this.field1658);
         this.method2063(this.field1658, this.field1658.vmethod2291());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class119 var10;
         label104:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if(var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class119 var11 = this.field1663[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        class122 var12 = var11.field1726;
                        if(var12 != null && var12.field1759 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1727;
                        } else {
                           var11.field1725 = true;
                           int var13 = var11.vmethod3888();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1759 += var13;
                           }

                           if(var4 >= this.field1651) {
                              break label104;
                           }

                           class119 var14 = var11.vmethod3864();
                           if(var14 != null) {
                              for(int var15 = var11.field1728; var14 != null; var14 = var11.vmethod3865()) {
                                 this.method2063(var14, var15 * var14.vmethod2291() >> 8);
                              }
                           }

                           class119 var18 = var11.field1727;
                           var11.field1727 = null;
                           if(var10 == null) {
                              this.field1663[var7] = var18;
                           } else {
                              var10.field1727 = var18;
                           }

                           if(var18 == null) {
                              this.field1662[var7] = var10;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class119 var16 = this.field1663[var6];
            class119[] var17 = this.field1663;
            this.field1662[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1727;
               var16.field1727 = null;
            }
         }
      }

      if(this.field1655 < 0) {
         this.field1655 = 0;
      }

      if(this.field1658 != null) {
         this.field1658.vmethod3889(var1, 0, var2);
      }

      this.field1652 = DState.currentTimeMs();
   }

   @ObfuscatedName("t")
   protected void write() throws Exception {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "1913986115"
   )
   public final synchronized void method2021(class119 var1) {
      this.field1658 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "420068294"
   )
   protected void vmethod2029() throws Exception {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "-1040321442"
   )
   public static void method2064(IndexDataBase var0) {
      class243.field3319 = var0;
   }
}