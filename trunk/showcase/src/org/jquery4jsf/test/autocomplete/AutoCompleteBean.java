/*
 *  Copyright (c) 2009 Giuseppe Trisciuoglio
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AutoCompleteBean.java

package org.jquery4jsf.test.autocomplete;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteBean
{

    public AutoCompleteBean()
    {
    }

    public String getValueOnAutoCompleteSubmit()
    {
        return valueOnAutoCompleteSubmit;
    }

    public void setValueOnAutoCompleteSubmit(String valueOnAutoCompleteSubmit)
    {
        this.valueOnAutoCompleteSubmit = valueOnAutoCompleteSubmit;
    }

    public List onCompleteCities(String name)
    {
        List listCities = new ArrayList();
        for(int i = 0; i < cities.length; i++)
        {
            String city = cities[i];
            if(city.toLowerCase().indexOf(name.toLowerCase()) > -1)
                listCities.add(city);
        }

        return listCities;
    }

    private String valueOnAutoCompleteSubmit;
    private static String cities[] = {
        "Aberdeen", "Ada", "Adamsville", "Addyston", "Adelphi", "Adena", "Adrian", "Akron", "Albany", "Alexandria", 
        "Alger", "Alledonia", "Alliance", "Alpha", "Alvada", "Alvordton", "Amanda", "Amelia", "Amesville", "Amherst", 
        "Amlin", "Amsden", "Amsterdam", "Andover", "Anna", "Ansonia", "Antwerp", "Apple Creek", "Arcadia", "Arcanum", 
        "Archbold", "Arlington", "Ashland", "Ashley", "Ashtabula", "Ashville", "Athens", "Attica", "Atwater", "Augusta", 
        "Aurora", "Austinburg", "Ava", "Avon", "Avon Lake", "Bainbridge", "Bakersville", "Baltic", "Baltimore", "Bannock", 
        "Barberton", "Barlow", "Barnesville", "Bartlett", "Barton", "Bascom", "Batavia", "Bath", "Bay Village", "Beach City", 
        "Beachwood", "Beallsville", "Beaver", "Beaverdam", "Bedford", "Bellaire", "Bellbrook", "Belle Center", "Belle Valley", "Bellefontaine", 
        "Bellevue", "Bellville", "Belmont", "Belmore", "Beloit", "Belpre", "Benton Ridge", "Bentonville", "Berea", "Bergholz", 
        "Berkey", "Berlin", "Berlin Center", "Berlin Heights", "Bethel", "Bethesda", "Bettsville", "Beverly", "Bidwell", "Big Prairie", 
        "Birmingham", "Blacklick", "Bladensburg", "Blaine", "Blakeslee", "Blanchester", "Blissfield", "Bloomdale", "Bloomingburg", "Bloomingdale", 
        "Bloomville", "Blue Creek", "Blue Rock", "Bluffton", "Bolivar", "Botkins", "Bourneville", "Bowerston", "Bowersville", "Bowling Green", 
        "Bradford", "Bradner", "Brady Lake", "Brecksville", "Bremen", "Brewster", "Brice", "Bridgeport", "Brilliant", "Brinkhaven", 
        "Bristolville", "Broadview Heights", "Broadway", "Brookfield", "Brookpark", "Brookville", "Brownsville", "Brunswick", "Bryan", "Buchtel", 
        "Buckeye Lake", "Buckland", "Bucyrus", "Buffalo", "Buford", "Burbank", "Burghill", "Burgoon", "Burkettsville", "Burton", 
        "Butler", "Byesville", "Cable", "Cadiz", "Cairo", "Caldwell", "Caledonia", "Cambridge", "Camden", "Cameron", 
        "Camp Dennison", "Campbell", "Canal Fulton", "Canal Winchester", "Canfield", "Canton", "Carbon Hill", "Carbondale", "Cardington", "Carey", 
        "Carroll", "Carrollton", "Casstown", "Castalia", "Catawba", "Cecil", "Cedarville", "Celina", "Centerburg", "Chagrin Falls", 
        "Chandlersville", "Chardon", "Charm", "Chatfield", "Chauncey", "Cherry Fork", "Chesapeake", "Cheshire", "Chester", "Chesterhill", 
        "Chesterland", "Chesterville", "Chickasaw", "Chillicothe", "Chilo", "Chippewa Lake", "Christiansburg", "Cincinnati", "Circleville", "Clarington", 
        "Clarksburg", "Clarksville", "Clay Center", "Clayton", "Cleveland", "Cleves", "Clifton", "Clinton", "Cloverdale", "Clyde", 
        "Coal Run", "Coalton", "Coldwater", "Colerain", "College Corner", "Collins", "Collinsville", "Colton", "Columbia Station", "Columbiana", 
        "Columbus", "Columbus Grove", "Commercial Point", "Conesville", "Conneaut", "Conover", "Continental", "Convoy", "Coolville", "Corning", 
        "Cortland", "Coshocton", "Covington", "Creola", "Crestline", "Creston", "Crooksville", "Croton", "Crown City", "Cuba", 
        "Cumberland", "Curtice", "Custar", "Cutler", "Cuyahoga Falls", "Cygnet", "Cynthiana", "Dalton", "Damascus", "Danville", 
        "Dayton", "De Graff", "Decatur", "Deerfield", "Deersville", "Defiance", "Delaware", "Dellroy", "Delphos", "Delta", 
        "Dennison", "Derby", "Derwent", "Deshler", "Dexter City", "Diamond", "Dillonvale", "Dola", "Donnelsville", "Dorset", 
        "Dover", "Doylestown", "Dresden", "Dublin", "Dunbridge", "Duncan Falls", "Dundee", "Dunkirk", "Dupont", "East Claridon", 
        "East Fultonham", "East Liberty", "East Liverpool", "East Palestine", "East Rochester", "East Sparta", "East Springfield", "Eastlake", "Eaton", "Edgerton", 
        "Edison", "Edon", "Eldorado", "Elgin", "Elkton", "Ellsworth", "Elmore", "Elyria", "Empire", "Englewood", 
        "Enon", "Etna", "Euclid", "Evansport", "Fairborn", "Fairfield", "Fairpoint", "Fairview", "Farmdale", "Farmer", 
        "Farmersville", "Fayette", "Fayetteville", "Feesburg", "Felicity", "Findlay", "Flat Rock", "Fleming", "Fletcher", "Flushing", 
        "Forest", "Fort Jennings", "Fort Loramie", "Fort Recovery", "Fostoria", "Fowler", "Frankfort", "Franklin", "Franklin Furnace", "Frazeysburg", 
        "Fredericksburg", "Fredericktown", "Freeport", "Fremont", "Fresno", "Friendship", "Fulton", "Fultonham", "Galena", "Galion", 
        "Gallipolis", "Galloway", "Gambier", "Garrettsville", "Gates Mills", "Geneva", "Genoa", "Georgetown", "Germantown", "Gettysburg", 
        "Gibsonburg", "Girard", "Glandorf", "Glencoe", "Glenford", "Glenmont", "Glouster", "Gnadenhutten", "Gomer", "Goshen", 
        "Grafton", "Grand Rapids", "Grand River", "Granville", "Gratiot", "Gratis", "Graysville", "Graytown", "Green", "Green Camp", 
        "Green Springs", "Greenfield", "Greenford", "Greentown", "Greenville", "Greenwich", "Grelton", "Grove City", "Groveport", "Grover Hill", 
        "Guysville", "Gypsum", "Hallsville", "Hamden", "Hamersville", "Hamilton", "Hamler", "Hammondsville", "Hannibal", "Hanoverton", 
        "Harbor View", "Harlem Springs", "Harpster", "Harrisburg", "Harrison", "Harrisville", "Harrod", "Hartford", "Hartville", "Harveysburg", 
        "Haskins", "Haverhill", "Haviland", "Haydenville", "Hayesville", "Heath", "Hebron", "Helena", "Hicksville", "Higginsport", 
        "Highland", "Hilliard", "Hillsboro", "Hinckley", "Hiram", "Hockingport", "Holgate", "Holland", "Hollansburg", "Holloway", 
        "Holmesville", "Homer", "Homerville", "Homeworth", "Hooven", "Hopedale", "Hopewell", "Houston", "Howard", "Hoytville", 
        "Hubbard", "Hudson", "Huntsburg", "Huntsville", "Huron", "Iberia", "Independence", "Irondale", "Ironton", "Irwin", 
        "Isle Saint George", "Jackson", "Jackson Center", "Jacksontown", "Jacksonville", "Jacobsburg", "Jamestown", "Jasper", "Jefferson", "Jeffersonville", 
        "Jenera", "Jeromesville", "Jerry City", "Jerusalem", "Jewell", "Jewett", "Johnstown", "Junction City", "Kalida", "Kansas", 
        "Keene", "Kelleys Island", "Kensington", "Kent", "Kenton", "Kerr", "Kettlersville", "Kidron", "Kilbourne", "Killbuck", 
        "Kimbolton", "Kings Mills", "Kingston", "Kingsville", "Kinsman", "Kipling", "Kipton", "Kirby", "Kirkersville", "Kitts Hill", 
        "Kunkle", "La Rue", "Lacarne", "Lafayette", "Lafferty", "Lagrange", "Laings", "Lake Milton", "Lakemore", "Lakeside Marblehead", 
        "Lakeview", "Lakeville", "Lakewood", "Lancaster", "Langsville", "Lansing", "Latham", "Latty", "Laura", "Laurelville", 
        "Leavittsburg", "Lebanon", "Lees Creek", "Leesburg", "Leesville", "Leetonia", "Leipsic", "Lemoyne", "Lewis Center", "Lewisburg", 
        "Lewistown", "Lewisville", "Liberty Center", "Lima", "Limaville", "Lindsey", "Lisbon", "Litchfield", "Lithopolis", "Little Hocking", 
        "Lockbourne", "Lodi", "Logan", "London", "Londonderry", "Long Bottom", "Lorain", "Lore City", "Loudonville", "Louisville", 
        "Loveland", "Lowell", "Lowellville", "Lower Salem", "Lucas", "Lucasville", "Luckey", "Ludlow Falls", "Lynchburg", "Lynx", 
        "Lyons", "Macedonia", "Macksburg", "Madison", "Magnetic Springs", "Magnolia", "Maineville", "Malaga", "Malinta", "Malta", 
        "Malvern", "Manchester", "Mansfield", "Mantua", "Maple Heights", "Maplewood", "Marathon", "Marengo", "Maria Stein", "Marietta", 
        "Marion", "Mark Center", "Marshallville", "Martel", "Martin", "Martins Ferry", "Martinsburg", "Martinsville", "Marysville", "Mason", 
        "Massillon", "Masury", "Maumee", "Maximo", "Maynard", "Mc Arthur", "Mc Clure", "Mc Comb", "Mc Connelsville", "Mc Cutchenville", 
        "Mc Dermott", "Mc Donald", "Mc Guffey", "Mechanicsburg", "Mechanicstown", "Medina", "Medway", "Melmore", "Melrose", "Mendon", 
        "Mentor", "Mesopotamia", "Metamora", "Miamisburg", "Miamitown", "Miamiville", "Middle Bass", "Middle Point", "Middlebranch", "Middleburg", 
        "Middlefield", "Middleport", "Middletown", "Midland", "Midvale", "Milan", "Milford", "Milford Center", "Millbury", "Milledgeville", 
        "Miller City", "Millersburg", "Millersport", "Millfield", "Milton Center", "Mineral City", "Mineral Ridge", "Minerva", "Minford", "Mingo", 
        "Mingo Junction", "Minster", "Mogadore", "Monclova", "Monroe", "Monroeville", "Montezuma", "Montpelier", "Montville", "Morral", 
        "Morristown", "Morrow", "Moscow", "Mount Blanchard", "Mount Cory", "Mount Eaton", "Mount Gilead", "Mount Hope", "Mount Liberty", "Mount Orab", 
        "Mount Perry", "Mount Pleasant", "Mount Saint Joseph", "Mount Sterling", "Mount Vernon", "Mount Victory", "Mowrystown", "Moxahala", "Munroe Falls", "Murray City", 
        "Nankin", "Napoleon", "Nashport", "Nashville", "Navarre", "Neapolis", "Neffs", "Negley", "Nelsonville", "Nevada", 
        "Neville", "New Albany", "New Athens", "New Bavaria", "New Bloomington", "New Bremen", "New Carlisle", "New Concord", "New Hampshire", "New Haven", 
        "New Holland", "New Knoxville", "New Lebanon", "New Lexington", "New London", "New Madison", "New Marshfield", "New Matamoras", "New Middletown", "New Paris", 
        "New Philadelphia", "New Plymouth", "New Richmond", "New Riegel", "New Rumley", "New Springfield", "New Straitsville", "New Vienna", "New Washington", "New Waterford", 
        "New Weston", "Newark", "Newbury", "Newcomerstown", "Newport", "Newton Falls", "Newtonsville", "Ney", "Niles", "North Baltimore", 
        "North Bend", "North Benton", "North Bloomfield", "North Fairfield", "North Georgetown", "North Hampton", "North Jackson", "North Kingsville", "North Lawrence", "North Lewisburg", 
        "North Lima", "North Olmsted", "North Ridgeville", "North Robinson", "North Royalton", "North Star", "Northfield", "Northwood", "Norwalk", "Norwich", 
        "Nova", "Novelty", "Oak Harbor", "Oak Hill", "Oakwood", "Oberlin", "Oceola", "Ohio City", "Okeana", "Okolona", 
        "Old Fort", "Old Washington", "Olmsted Falls", "Ontario", "Orangeville", "Oregon", "Oregonia", "Orient", "Orrville", "Orwell", 
        "Osgood", "Ostrander", "Ottawa", "Ottoville", "Otway", "Overpeck", "Owensville", "Oxford", "Painesville", "Palestine", 
        "Pandora", "Paris", "Parkman", "Pataskala", "Patriot", "Paulding", "Payne", "Pedro", "Peebles", "Pemberton", 
        "Pemberville", "Peninsula", "Perry", "Perrysburg", "Perrysville", "Petersburg", "Pettisville", "Phillipsburg", "Philo", "Pickerington", 
        "Piedmont", "Pierpont", "Piketon", "Piney Fork", "Pioneer", "Piqua", "Pitsburg", "Plain City", "Plainfield", "Pleasant City", 
        "Pleasant Hill", "Pleasant Plain", "Pleasantville", "Plymouth", "Polk", "Pomeroy", "Port Clinton", "Port Jefferson", "Port Washington", "Port William", 
        "Portage", "Portland", "Portsmouth", "Potsdam", "Powell", "Powhatan Point", "Proctorville", "Prospect", "Put in Bay", "Quaker City", 
        "Quincy", "Racine", "Radnor", "Randolph", "Rarden", "Ravenna", "Rawson", "Ray", "Rayland", "Raymond", 
        "Reedsville", "Reesville", "Reno", "Republic", "Reynoldsburg", "Richfield", "Richmond", "Richmond Dale", "Richwood", "Ridgeville Corners", 
        "Ridgeway", "Rio Grande", "Ripley", "Risingsun", "Rittman", "Robertsville", "Rock Camp", "Rock Creek", "Rockbridge", "Rockford", 
        "Rocky Ridge", "Rocky River", "Rogers", "Rome", "Rootstown", "Roseville", "Rosewood", "Ross", "Rossburg", "Rossford", 
        "Roundhead", "Rudolph", "Rushsylvania", "Rushville", "Russells Point", "Russellville", "Russia", "Rutland", "Sabina", "Saint Clairsville", 
        "Saint Henry", "Saint Johns", "Saint Louisville", "Saint Marys", "Saint Paris", "Salem", "Salesville", "Salineville", "Sandusky", "Sandyville", 
        "Sarahsville", "Sardinia", "Sardis", "Savannah", "Scio", "Scioto Furnace", "Scott", "Scottown", "Seaman", "Sebring", 
        "Sedalia", "Senecaville", "Seven Mile", "Seville", "Shade", "Shadyside", "Shandon", "Sharon Center", "Sharpsburg", "Shauck", 
        "Shawnee", "Sheffield Lake", "Shelby", "Sherrodsville", "Sherwood", "Shiloh", "Short Creek", "Shreve", "Sidney", "Sinking Spring", 
        "Smithfield", "Smithville", "Solon", "Somerdale", "Somerset", "Somerville", "South Bloomingville", "South Charleston", "South Lebanon", "South Point", 
        "South Salem", "South Solon", "South Vienna", "South Webster", "Southington", "Sparta", "Spencer", "Spencerville", "Spring Valley", "Springboro", 
        "Springfield", "Stafford", "Sterling", "Steubenville", "Stewart", "Stillwater", "Stockdale", "Stockport", "Stone Creek", "Stony Ridge", 
        "Stout", "Stoutsville", "Stow", "Strasburg", "Stratton", "Streetsboro", "Strongsville", "Struthers", "Stryker", "Sugar Grove", 
        "Sugarcreek", "Sullivan", "Sulphur Springs", "Summerfield", "Summit Station", "Summitville", "Sunbury", "Swanton", "Sycamore", "Sycamore Valley", 
        "Sylvania", "Syracuse", "Tallmadge", "Tarlton", "Terrace Park", "The Plains", "Thompson", "Thornville", "Thurman", "Thurston", 
        "Tiffin", "Tiltonsville", "Tipp City", "Tippecanoe", "Tiro", "Toledo", "Tontogany", "Torch", "Toronto", "Tremont City", 
        "Trenton", "Trimble", "Trinway", "Troy", "Tuppers Plains", "Tuscarawas", "Twinsburg", "Uhrichsville", "Union City", "Union Furnace", 
        "Unionport", "Uniontown", "Unionville", "Unionville Center", "Uniopolis", "Upper Sandusky", "Urbana", "Utica", "Valley City", "Van Buren", 
        "Van Wert", "Vandalia", "Vanlue", "Vaughnsville", "Venedocia", "Vermilion", "Verona", "Versailles", "Vickery", "Vienna", 
        "Vincent", "Vinton", "Wadsworth", "Wakefield", "Wakeman", "Walbridge", "Waldo", "Walhonding", "Walnut Creek", "Wapakoneta", 
        "Warnock", "Warren", "Warsaw", "Washington Court House", "Washingtonville", "Waterford", "Waterloo", "Watertown", "Waterville", "Wauseon", 
        "Waverly", "Wayland", "Wayne", "Waynesburg", "Waynesfield", "Waynesville", "Wellington", "Wellston", "Wellsville", "West Alexandria", 
        "West Chester", "West Elkton", "West Farmington", "West Jefferson", "West Lafayette", "West Liberty", "West Manchester", "West Mansfield", "West Millgrove", "West Milton", 
        "West Point", "West Portsmouth", "West Rushville", "West Salem", "West Union", "West Unity", "Westerville", "Westfield Center", "Westlake", "Weston", 
        "Westville", "Wharton", "Wheelersburg", "Whipple", "White Cottage", "Whitehouse", "Wickliffe", "Wilberforce", "Wilkesville", "Willard", 
        "Williamsburg", "Williamsfield", "Williamsport", "Williamstown", "Williston", "Willoughby", "Willow Wood", "Willshire", "Wilmington", "Wilmot", 
        "Winchester", "Windham", "Windsor", "Winesburg", "Wingett Run", "Winona", "Wolf Run", "Woodsfield", "Woodstock", "Woodville", 
        "Wooster", "Wren", "Xenia", "Yellow Springs", "Yorkshire", "Yorkville", "Youngstown", "Zaleski", "Zanesfield", "Zanesville", 
        "Zoar"
    };

}
