/*
 *  Copyright 2009, Plutext Pty Ltd.
 *   
 *  This file is part of docx4j.

    docx4j is licensed under the Apache License, Version 2.0 (the "License"); 
    you may not use this file except in compliance with the License. 

    You may obtain a copy of the License at 

        http://www.apache.org/licenses/LICENSE-2.0 

    Unless required by applicable law or agreed to in writing, software 
    distributed under the License is distributed on an "AS IS" BASIS, 
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
    See the License for the specific language governing permissions and 
    limitations under the License.

 */

package org.docx4j.model.structure;

import java.math.BigInteger;

import org.docx4j.jaxb.Context;
import org.docx4j.wml.SectPr.PgMar;
import org.docx4j.wml.SectPr.PgSz;

public class PageDimensions {
	
	// Defaults - if values aren't defined in sectPr 
	// TODO - replace this with convenience methods
	// to set defaults for A4, Letter etc
	public static int DEFAULT_PAGE_WIDTH_TWIPS = 12240;  // Letter; A4 would be 11907  
	public static int DEFAULT_LEFT_MARGIN_TWIPS = 1440;  // 1 inch
	public static int DEFAULT_RIGHT_MARGIN_TWIPS = 1440;
	// TODO - defaults for the other fields
	
	// TODO - and independently, to set
	// margins to Normal, Narrow, Office 2003 default
	
	int pageWidth = DEFAULT_PAGE_WIDTH_TWIPS;
	int pageHeight = 15840;
	
	int marginTop = 1440;
	int marginBottom = 1440;
	int marginLeft = DEFAULT_LEFT_MARGIN_TWIPS;
	int marginRight = DEFAULT_RIGHT_MARGIN_TWIPS;

	int marginHeader = 708;
	int marginFooter = 708;
	int marginGutter = 0;		
	
	public void setA4Defaults() {
		/* Mimic
			<w:pgSz w:w="12240" w:h="15840"/>^M
            <w:pgMar w:top="1440" w:right="1440" w:bottom="1440" w:left="1440" 
            		 w:header="708" w:footer="708" w:gutter="0"/>
		 */
		pageWidth = DEFAULT_PAGE_WIDTH_TWIPS;
		pageHeight = 15840;
		
		marginTop = 1440;
		marginBottom = 1440;
		marginLeft = DEFAULT_LEFT_MARGIN_TWIPS;
		marginRight = DEFAULT_RIGHT_MARGIN_TWIPS;

		marginHeader = 708;
		marginFooter = 708;
		marginGutter = 0;		
	}
	
	public void setPageSize(PgSz pgSz ) {
		
		if (pgSz!=null) {
			if (pgSz.getW()!=null) {
				pageWidth = pgSz.getW().intValue();
			}
			if (pgSz.getH()!=null) {
				pageHeight = pgSz.getH().intValue();
			}
		}		
	}
	
	public PgSz createPgSize() {
		
		PgSz pgSz = Context.getWmlObjectFactory().createSectPrPgSz();
		
		pgSz.setW( BigInteger.valueOf(pageWidth) );
		pgSz.setH( BigInteger.valueOf(pageHeight) );
		
		return pgSz;		
	}
	
	public void setMargins(PgMar pgMar) {
				
		if (pgMar!=null) {
			if (pgMar.getTop()!=null) {
				marginTop = pgMar.getTop().intValue();
			}
		
			if (pgMar.getBottom()!=null) {
				marginBottom = pgMar.getBottom().intValue();
			}
			if (pgMar.getLeft()!=null) {
				marginLeft = pgMar.getLeft().intValue();
			}
			if (pgMar.getRight()!=null) {
				marginRight = pgMar.getRight().intValue();
			}
			
			if (pgMar.getHeader()!=null) {
				marginHeader = pgMar.getHeader().intValue();
			}
			if (pgMar.getFooter()!=null) {
				marginFooter = pgMar.getFooter().intValue();
			}
			if (pgMar.getGutter()!=null) {
				marginGutter = pgMar.getGutter().intValue();
			}
		}		
	}

	public PgMar createPgMar() {
		
		PgMar pgMar = Context.getWmlObjectFactory().createSectPrPgMar();
		
		pgMar.setTop(    BigInteger.valueOf(marginTop) );
		pgMar.setBottom( BigInteger.valueOf(marginBottom) );
		pgMar.setLeft(   BigInteger.valueOf(marginLeft) );
		pgMar.setRight(  BigInteger.valueOf(marginRight) );

		pgMar.setHeader( BigInteger.valueOf(marginHeader) );
		pgMar.setFooter( BigInteger.valueOf(marginFooter) );
		pgMar.setGutter( BigInteger.valueOf(marginGutter) );
		
		return pgMar;		
	}
	
	
	/**
	 * @return the pageWidth
	 */
	public int getPageWidth() {
		return pageWidth;
	}

	/**
	 * @param pageWidth the pageWidth to set
	 */
	public void setPageWidth(int pageWidth) {
		this.pageWidth = pageWidth;
	}
	
	public int getWritableWidthTwips() {
		return pageWidth - (marginLeft + marginRight);		
	}

	/**
	 * @return the pageHeight
	 */
	public int getPageHeight() {
		return pageHeight;
	}

	/**
	 * @param pageHeight the pageHeight to set
	 */
	public void setPageHeight(int pageHeight) {
		this.pageHeight = pageHeight;
	}

	/**
	 * @return the marginTop
	 */
	public int getMarginTop() {
		return marginTop;
	}

	/**
	 * @param marginTop the marginTop to set
	 */
	public void setMarginTop(int marginTop) {
		this.marginTop = marginTop;
	}

	/**
	 * @return the marginBottom
	 */
	public int getMarginBottom() {
		return marginBottom;
	}

	/**
	 * @param marginBottom the marginBottom to set
	 */
	public void setMarginBottom(int marginBottom) {
		this.marginBottom = marginBottom;
	}

	/**
	 * @return the marginLeft
	 */
	public int getMarginLeft() {
		return marginLeft;
	}

	/**
	 * @param marginLeft the marginLeft to set
	 */
	public void setMarginLeft(int marginLeft) {
		this.marginLeft = marginLeft;
	}

	/**
	 * @return the marginRight
	 */
	public int getMarginRight() {
		return marginRight;
	}

	/**
	 * @param marginRight the marginRight to set
	 */
	public void setMarginRight(int marginRight) {
		this.marginRight = marginRight;
	}

	/**
	 * @return the marginHeader
	 */
	public int getMarginHeader() {
		return marginHeader;
	}

	/**
	 * @param marginHeader the marginHeader to set
	 */
	public void setMarginHeader(int marginHeader) {
		this.marginHeader = marginHeader;
	}

	/**
	 * @return the marginFooter
	 */
	public int getMarginFooter() {
		return marginFooter;
	}

	/**
	 * @param marginFooter the marginFooter to set
	 */
	public void setMarginFooter(int marginFooter) {
		this.marginFooter = marginFooter;
	}

	/**
	 * @return the marginGutter
	 */
	public int getMarginGutter() {
		return marginGutter;
	}

	/**
	 * @param marginGutter the marginGutter to set
	 */
	public void setMarginGutter(int marginGutter) {
		this.marginGutter = marginGutter;
	}

}
